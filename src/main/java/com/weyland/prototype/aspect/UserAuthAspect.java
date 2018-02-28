package com.weyland.prototype.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAuthAspect {

    //在路径的controller方法执行前都会执行该方法,方法名为*则代表所有方法
    @Before("execution(public * com.weyland.prototype.controller.UserAuthController.userList(..))")
    public void testBefore(){
        System.out.println("< === executed before controller === >");
    }

    @After("execution(public * com.weyland.prototype.controller.UserAuthController.userList(..))")
    public void testAfter(){
        System.out.println("< === executed after controller === >");
    }
}
