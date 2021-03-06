package com.example.demo.controller;

import com.example.demo.Mapper.SeatMapper;
import com.example.demo.entity.Seat;
import com.example.demo.service.SeatService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebSeatController {
    @Autowired
    private SeatService seatService;
    @Autowired
    private SeatMapper seatMapper;

    @RequestMapping("/seatList")
    public String list(@RequestParam(name = "seat_id", defaultValue = "") Integer seatId,
                       @RequestParam(name = "show_id", defaultValue = "") Integer showId,
                       @RequestParam(name = "coordinate_x", defaultValue = "") Integer coordinateX,
                       @RequestParam(name = "coordinate_y", defaultValue = "") Integer coordinateY,
                       @RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "6") Integer pageSize,
                       Model model) {

        model.addAttribute("seat_id", seatId);
        model.addAttribute("show_id", showId);
        model.addAttribute("coordinate_x", coordinateX);
        model.addAttribute("coordinate_y", coordinateY);
        PageInfo<Seat> pageData = seatService.pageQuery(seatId, showId, coordinateX, coordinateY, pageNum, pageSize);
        model.addAttribute("pageInfo", pageData);
        System.out.println("--------显示座位信息---------");
        return "forward:/seat/seatList.jsp";

    }

    @RequestMapping("/viewSeat")
    public String view(Integer seatId, Model model) {
        Seat seat = seatMapper.selectById(seatId);
        model.addAttribute("obj", seat);
        return "forward:/seat/view.jsp";
    }

    @RequestMapping("/addSeat")
    public String add(Seat seat,Model model ){
        seatMapper.insert(seat);

        PageInfo<Seat> pageData = seatService.pageQuery(null, null, null, null, 1, 6);
        model.addAttribute("pageInfo", pageData);
        System.out.println("--------显示座位信息---------");
        return "forward:/seat/seatList.jsp";

       // return "forward:/main_admin";// 返回列表页面
    }


    @RequestMapping("/isExistSeat")
    @ResponseBody
    public String isExist(Integer showId,Integer coordinateX,Integer coordinateY){
        int count = seatMapper.countByData(showId,coordinateX,coordinateY);
        if(count>0){
            System.out.println("-------------yes----------");
            return "yes";
        }else{
            System.out.println("-------------no----------");
            return "no";
        }
    }

}
