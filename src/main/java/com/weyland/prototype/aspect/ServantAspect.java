package com.weyland.prototype.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * \* Created with IntelliJ IDEA.
 * \* Creator: LayWin
 * \* CreateTime: 2018/3/4 22:32
 * \* Description:
 */
public class ServantAspect {

    private static final Logger logger = LoggerFactory.getLogger(ServantAspect.class);

    //Pointcut设置路径，其他方法引用
    @Pointcut("execution(public * com.weyland.prototype.controller.ServantController.getAllServant(..))")
    public void testExample(){
//        该方法内容不会执行
//        System.out.println("< === executed pointcut example === >");
    }
    @Before("testExample()")
    public void testBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url 请求url
        logger.info("url={}",request.getRequestURL());
        //method 请求方式
        logger.info("method={}",request.getRequestURL());
        //ip 请求的ip地址
        logger.info("ip={}",request.getRemoteAddr());
        //class method 请求的类名及方法名
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //args 请求参数
        logger.info("args={}",joinPoint.getArgs());

        //日志打印通知到控制台
        logger.info("< === executed pointcut BEFORE=== >");
    }
    @After("testExample()")
    public void testAfter(){
        //日志打印错误到控制台
        logger.error("< === executed pointcut AFTER=== >");
    }

    @AfterReturning(pointcut = "testExample()" , returning = "object")
    public void testReturn(Object object){
        logger.info("response={}",object);
    }

}
