package com.hxb.oldBook.aspect;

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
 * @CreateDate: 2018/5/3 14:16
 * @Description: 权限校验
 **/
@Component
@Aspect
@Order(1)
public class LoginAspect {

    private final Logger logger = LoggerFactory.getLogger(LoginAspect.class);

    @Pointcut("within(com.hxb.oldBook.controller..*) && !within(com.hxb.oldBook.controller.NoNeedLoginController)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object checkLogin(ProceedingJoinPoint pjp) throws Throwable {
        HttpSession session = RequestUtil.getSession();
        String isLogin = (String) session.getAttribute("isLogin");
        if (isLogin == null) {
            logger.info("------没有登录-----");
            return "redirect:/toLogin";
        } else {
         return pjp.proceed();
        }
    }

}
