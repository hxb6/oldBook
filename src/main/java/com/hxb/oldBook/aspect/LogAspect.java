package com.hxb.oldBook.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
/**
 * @Package: com.hxb.oldBook.aspect
 * @Author: HeXiaoBo
 * @CreateDate: 2018/4/25 14:42
 * @Description: 日志切面类 记录请求相关参数
 **/
@Component
@Aspect
//Order注解控制多个Aspect的执行顺序,越小越先执行
@Order(2)
public class LogAspect {

    /**
     * 创建日志对象
     */
    protected final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 切入点 controller包及其子包下所有类中所有的方法
     */
    @Pointcut("execution(* com.hxb.oldBook.controller.*.*(..))")
    public void pointCut() {
    }

    /**
     * 请求之前记录日志
     *
     * @param joinPoint JoinPoint对象
     *                  JoinPoint对象封装了SpringAop中切面方法的信息
     *                  在切面方法中添加JoinPoint参数,就可以获取到封装了该方法信息的JoinPoint对象.
     */
    @Before("pointCut()")
    public void recordLog(JoinPoint joinPoint) {
        /*
            1.从RequestContextHolder中获取 RequestAttributes 对象
            2.再类型转换  将RequestAttributes接口转换为其实现类ServletRequestAttributes
            3.调用getRequest()获取HttpServletRequest对象实例
         */
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) attributes).getRequest();

        //请求的URL
        logger.info("url={}", request.getRequestURL());
        //请求方式
        logger.info("method={}", request.getMethod());
        //请求ip
        logger.info("ip={}", request.getRemoteAddr());
        //请求的类和类中的方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //获取传入目标方法的参数对象
        logger.info("args={}", joinPoint.getArgs());

    }
}
