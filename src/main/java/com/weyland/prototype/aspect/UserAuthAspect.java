package com.weyland.prototype.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* Creator: LayWin
 * \* CreateTime: 2017/10/30 22:44
 * \* Description:
 */

@Aspect
@Component
public class UserAuthAspect {

    private final static Logger logger = LoggerFactory.getLogger(UserAuthAspect.class);

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
