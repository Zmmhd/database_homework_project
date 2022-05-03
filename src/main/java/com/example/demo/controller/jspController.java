package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 定义对主页访问映射
 */
@Controller
public class jspController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    //@RequestMapping("/")
    public String index(){
        return "index";
    }
}
