package com.weyland.prototype.controller;

import com.weyland.prototype.domain.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* Creator: LayWin
 * \* CreateTime: 2017/10/30 22:44
 * \* Description:
 */

//RestController相当于Controller+ResponseBody，返回字符串或者json数组
@RestController

//可以在controller前加访问父路径
//@RequestMapping("weyland")
public class BasicController {

//  请求的 映射路径 和 请求方式 只返回字符串到页面
//  value的值可以是集合，也就是集合内的路径都是此请求
    @RequestMapping(value = {"/title","/main"}, method= RequestMethod.GET)
    public String showTitle() {
        return "Building Better Worlds";
    }

//  --------------------------------------------------------------------------------------------------------------------
//  注解对应application配置文件中的自定义变量
    @Value("${name}")
    private String name;

    @Value("${securityCode}")
    private String securityCode;

//  包含name和securityCode的内容
    @Value("${record}")
    private String record;

//  --------------------------------------------------------------------------------------------------------------------

    @RequestMapping(value = "/show1",method = RequestMethod.GET)
    public String showRecord1(){
        return name+securityCode;
    }

    @RequestMapping(value = "/show2",method = RequestMethod.GET)
    public String showRecord2(){
        return record;
    }

//  --------------------------------------------------------------------------------------------------------------------
//  自动生成Visitor对象
    @Autowired
    private Visitor visitor;

    @RequestMapping(value = "/show3",method = RequestMethod.GET)
    public String showRecord3(){
        return visitor.getName()+visitor.getSecurityCode();
    }

//  --------------------------------------------------------------------------------------------------------------------
//    @RequestMapping(value = "/showId",method = RequestMethod.GET)
    @GetMapping(value = "/showId")
//  @RequestParam("yourId")必须对应url中的yourId，而String 后的id则随意
//  url写为/showId?yourId=xxx
    public String showYourId(@RequestParam(value = "yourId",defaultValue = "Agent") String id){
        return "your id is "+id;
    }

//    @RequestMapping(value = {"/showName/{myName}","/{myName}/showName"},method = RequestMethod.GET)
    @GetMapping(value = {"/showName/{myName}","/{myName}/showName"})
//  @PathVariable("myName")必须对应url中的{myName}，而String 后的name则随意
//  url写为/showName/xxx 或者 /xxx/showName
    public String showYourName(@PathVariable(value = "myName") String name){
        return "your name is "+name;
    }





}
