package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ShowService showService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private SeatService seatService;


    @RequestMapping(value = "/register",method = RequestMethod.POST) //, method = RequestMethod.POST
    public String registerUser(User user,HttpServletRequest request, HttpServletResponse response) {
        try {
            userService.register(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "redirect:/406.jsp";
        }
        request.getSession().setAttribute("userId",user.getUserId());
        return "indexuser";
    }


    @RequestMapping("/login")
    public String login(String userId, String password, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // 验证账号和密码
        // 账号密码正确则登录成功，否则返回首页
        User user = userService.validateLogin(userId);
        if (user == null) {
            Admin admin = adminService.getAdminById(userId);
            // 没有找到，返回管理员登录界面
            if(admin == null){
                request.setAttribute("errorMsg", "该用户不存在");
                return "redirect:/407.jsp";
            }
            else {
                if (password.equals(admin.getPassword())) {
                    request.getSession().setAttribute("admin", admin);
//                System.out.println(2222);
                    return  "redirect:/main_admin.jsp";
                } else {
                    request.setAttribute("errorMsg", "管理员密码错误");
                    return "redirect:/404.jsp";
                }
            }

        } else {

            if (password.equals(user.getPassword())) {
                request.getSession().setAttribute("userId", userId);
                request.getSession().setAttribute("nickname",user.getNickname());
                return "indexuser";
            } else {
                request.setAttribute("errorMsg", "用户密码错误");
                return "redirect:/404.jsp";
            }
        }
    }
    @RequestMapping("/listorder")
    public String listOrder(HttpServletRequest request){
        String userId = (String) request.getSession().getAttribute("userId");
        List<Order> orderList = orderService.getOrderByUserId(userId);
        request.setAttribute("orderList",orderList);

        return "indexuser"; //应该是转发
    }


    @Transactional
    @RequestMapping("/removeorder")
    public String removeOrder(@RequestParam("orderId") int orderId){
        orderService.deleteOrder(orderId);
        return "indexuser";
    }

    @Transactional
    @RequestMapping("/selectshow")
    public String selectShow(@RequestParam("showId") Integer showId ,HttpServletRequest request,
         @RequestParam(name = "seat_id", defaultValue = "") Integer seatId,
         @RequestParam(name = "coordinate_x", defaultValue = "") Integer coordinateX,
         @RequestParam(name = "coordinate_y", defaultValue = "") Integer coordinateY,
         @RequestParam(defaultValue = "1") Integer pageNum,
         @RequestParam(defaultValue = "6") Integer pageSize,
         Model model
    ){
        model.addAttribute("seat_id", seatId);
        model.addAttribute("show_id", showId);
        model.addAttribute("coordinate_x", coordinateX);
        model.addAttribute("coordinate_y", coordinateY);
        PageInfo<Seat> pageData = seatService.pageQuery(seatId, showId, coordinateX, coordinateY, pageNum, pageSize);
        model.addAttribute("pageInfo", pageData);


        String userId = (String) request.getSession().getAttribute("userId");
        Show show = showService.getShowById(showId);
        Order order  = new Order(null,userId,show.getShowId(),1,"普通座位",show.getShowName(),show.getShowTime());
        request.getSession().setAttribute("order",order);
        return "forward:/userseatList.jsp"; //应该是转发
    }

    @RequestMapping("/selectseat")
    public String selectSeat(@RequestParam("seatId") Integer seatId ,HttpServletRequest request){
        Order order = (Order) request.getSession().getAttribute("order");
        order.setSeatId(seatId);
        orderService.addOrder(order);
        return "indexuser";
    }



    @RequestMapping("/listshow")
    public String list(@RequestParam(name = "show_id", defaultValue = "") Integer showId,
                       @RequestParam(name = "show_name", defaultValue = "") String showName,
                       @RequestParam(defaultValue = "", name = "show_type") String showType,
                       @RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "5") Integer pageSize,
                       Model model) {
        model.addAttribute("show_id", showId);// 将演出编号放到model
        model.addAttribute("show_name", showName);// 将演出名称放到model
        model.addAttribute("show_type", showType);
        PageInfo<Show> pageData = showService.pageQuery(showId, showName, showType, pageNum, pageSize);
        // 将数据放到model
        model.addAttribute("pageInfo", pageData);
        System.out.println("--------显示演出信息---------");
        return "forward:/usershowList.jsp";// 转到演出信息页面展示
    }





    @RequestMapping("/userinfo")
    public Model userInfo(HttpServletRequest request,Model model){
        String userId = (String) request.getSession().getAttribute("userId");

        User user = userService.getUserById(userId);
        model.addAttribute("user",user);

        return model;
    }

    @RequestMapping("/modifyuser")
    public String modifyUser(User user,HttpServletRequest request){
        userService.modifyUser(user);
        request.getSession().setAttribute("nickname",user.getNickname());
        return "indexuser";
    }



    @RequestMapping("/modifypassword")
    public String modifyPassword(@RequestParam("userId") String userId,
                                 @RequestParam("oldpassword") String oldpassword,
                                 @RequestParam("newpassword") String newpassword
                                 ){

        User user = userService.getUserById(userId);
        if(! (user.getPassword().equals(oldpassword)))
        {
            return "408";
        }
        else {
            user.setPassword(newpassword);
            userService.modifyUser(user);
        }
        return "index"; //登录之前的主页
    }



    @RequestMapping("logout")
    public String logOut(HttpServletRequest request, HttpSession session){
        System.out.println("logout");
        //session失效
        session.removeAttribute("userId");
        session.removeAttribute("nickname");
        return "redirect:/login";
    }


}
