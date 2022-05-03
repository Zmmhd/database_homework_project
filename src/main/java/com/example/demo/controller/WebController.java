package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class WebController {
    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/adminlogin")
    public String adminLogin(){

        return "adminlogin";
    }

    @RequestMapping("/register")
    public String register(){

        return "register";
    }

    @RequestMapping("/user_main")
    public String user(HttpServletRequest request, Model model){
        /***
         * 查询个人信息
         */
        String userId = (String) request.getSession().getAttribute("userId");
        User user = userService.getUserById(userId);

        model.addAttribute("nickname",user.getNickname());
        model.addAttribute("phonenumber",user.getPhoneNumber());
        model.addAttribute("email",user.getEmail());
        model.addAttribute("introduction",user.getIntroduction());
        model.addAttribute("age",user.getAge());
        model.addAttribute("city",user.getCity());


        List<Order> orderList = orderService.getOrderByUserId(userId);
        model.addAttribute("orderList",orderList);



        return "user";
    }
    @RequestMapping("kepu")
    public String kepu(){
        return "kepu";
    }
}
