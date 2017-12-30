package com.lzk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lzk on 2017/12/25 22:00
 * Description:HelloWorld
 */
@Controller
public class HelloWorld {

    /**
     * 1、使用@RequestMapping注解映射请求的url
     * 2、返回值会通过视图解析器解析为实际的物理视图，
     * 对于InternalResourceViewResolver视图解析器，会做如下的解析：
     * 通过prefix + returnVal + suffix这样的方式得到实际的物理视图，然后做转发操作
     *
     * /WEB-INF/views/success.jsp
     * @return
     */
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello world!");
        return "success";
    }
}
