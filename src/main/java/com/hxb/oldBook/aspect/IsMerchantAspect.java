package com.hxb.oldBook.aspect;

import com.hxb.oldBook.pojo.User;
import com.hxb.oldBook.utils.RequestUtil;
import com.hxb.oldBook.utils.UserUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * @Package: com.hxb.oldBook.aspect
 * @Author: HeXiaoBo
 * @CreateDate: 2018/5/4 16:46
 * @Description: 针对用户是商家操作的切面 检查用户是否是商家
 **/
@Component
@Aspect
@Order(3)
public class IsMerchantAspect {

    /**
     * 创建日志对象
     */
    protected final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     *切入点
     */
    @Pointcut("within(com.hxb.oldBook.controller.shop.MyShopInfoController)")
    public void pointCut(){};

    /**
     *  检查用户是否是商家 是则进行后续操作 不是则跳转到申请商家页面
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("pointCut()")
    public Object checkIsMerchant(ProceedingJoinPoint pjp) throws Throwable{
        //从session中得到登录用户
        User user = UserUtil.getUserFormSession();
        /*
            如果用户是商家 继续执行后续操作
            否则前去申请成为商家页面
         */
        if (user.getIsMerchant()) {
            return pjp.proceed();
        } else {
            logger.info("--------用户不是商家---------");
            return "redirect:/user/apply";
        }
    }

}
