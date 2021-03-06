package com.example.demo.controller;

import com.example.demo.Mapper.OrderMapper;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebOrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping("/orderList")
    public String list(@RequestParam(name = "order_id", defaultValue = "") Integer orderId,
                       @RequestParam(name = "user_id", defaultValue = "") String userId,
                       @RequestParam(name = "show_id",defaultValue = "") Integer showId,
                       @RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "4") Integer pageSize,
                       Model model) {

        String user_id = userId;
        if (!"".equals(user_id)) {
            user_id = "%" + user_id + "%";
        }
        model.addAttribute("order_id", orderId);// 将意见反馈编号放到model
        model.addAttribute("user_id", userId);// 将意见反馈类型名称放到model
        model.addAttribute("show_id", showId);// 将意见反馈内容放到model
        PageInfo<Order> pageData = orderService.pageQuery(orderId, userId,showId, pageNum, pageSize);
        // 将数据放到model
        model.addAttribute("pageInfo", pageData);
        System.out.println("--------显示用户订单信息---------");
        return "forward:/order/orderList.jsp";// 转到演出信息页面展示

    }


    @RequestMapping("/viewOrder")
    public String view(Integer orderId, Model model) {
        // 根据编号去查询文章信息
        Order order  = orderMapper.selectById(orderId);
        // 将查询的博主文章数据放入model中
        model.addAttribute("obj", order);
        return "forward:/order/view.jsp";// 跳转显示页面
    }
}
