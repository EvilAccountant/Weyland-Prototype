package com.weyland.prototype.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * \* Created with IntelliJ IDEA.
 * \* Creator: LayWin
 * \* CreateTime: 2017/11/2 11:14
 * \* Description:
 * \
 */

//Controller需要配合模板引擎使用，例如thymeleaf，return的值为templates下的页面的名字
@Controller
public class VideoController {
    @RequestMapping(value = "/showVideo", method = RequestMethod.GET)
    public String showVideo(){
        return "videoTest";
    }
}
