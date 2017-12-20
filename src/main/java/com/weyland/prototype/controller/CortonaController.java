package com.weyland.prototype.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * \* Created with IntelliJ IDEA.
 * \* Creator: LayWin
 * \* CreateTime: 2017/11/1 14:49
 * \* Description:用于展示Cortona3D模型的控制器
 * \
 */

@Controller
public class CortonaController
{
    @RequestMapping(value = "/show3D",method = RequestMethod.GET)
    public String show3D(){
        return "cortonaTest";
    }

}
