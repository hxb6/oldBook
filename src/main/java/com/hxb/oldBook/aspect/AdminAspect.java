package com.hxb.oldBook.aspect;

import com.hxb.oldBook.pojo.User;
import com.hxb.oldBook.utils.RequestUtil;
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
 * @CreateDate: 2018/5/7 13:31
 * @Description: 管理员操作需要验证的切面 判断登录用户是否是管理员
 **/
@Component
@Aspect
@Order(4)
public class AdminAspect {
    private final Logger logger = LoggerFactory.getLogger(LoginAspect.class);

    /**
     * 切入点 admin包及其子包下的所有方法
     */
    @Pointcut("within(com.hxb.oldBook.controller.admin..*)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object checkLogin(ProceedingJoinPoint pjp) throws Throwable {
        HttpSession session = RequestUtil.getSession();
        User user = (User) session.getAttribute("user");
        if (user.getRoleType() == 1) {
            logger.info("------登录用户不是管理员-----");
            return "redirect:/toLogin";
        } else {
            logger.info("------管理员[" + user.getUserName() + "]-------登录");
            return pjp.proceed();
        }
    }
}
