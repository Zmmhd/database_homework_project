package com.example.demo.controller;

import com.example.demo.Mapper.FeedbackMapper;
import com.example.demo.entity.Feedback;
import com.example.demo.service.FeedbackService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebFeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private FeedbackMapper feedbackMapper;

    @RequestMapping("/feedbackList")
    public String list(@RequestParam(name = "feedback_id", defaultValue = "") Integer feedbackId,
                       @RequestParam(name = "feedback_type", defaultValue = "") String feedbackType,
                       @RequestParam(name = "feedback",defaultValue = "") String feedback,
                       @RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "4") Integer pageSize,
                       Model model) {
        // 获取反馈的信息
        String feedBack = feedback;
        if (!"".equals(feedBack)) {
            feedBack = "%" + feedBack + "%";
        }
        model.addAttribute("feedback_id", feedbackId);// 将意见反馈编号放到model
        model.addAttribute("feedback_type", feedbackType);// 将意见反馈类型名称放到model
        model.addAttribute("feedback", feedback);// 将意见反馈内容放到model
        PageInfo<Feedback> pageData = feedbackService.pageQuery(feedbackId, feedbackType,feedback, pageNum, pageSize);
        // 将数据封装model
        model.addAttribute("pageInfo", pageData);
        System.out.println("--------显示意见反馈信息---------");
        return "forward:/feedback/feedbackList.jsp";// 转到演出信息页面展示
    }


    @RequestMapping("/deleteFeedback")
    public String delete(Integer feedbackId, Model model) {
        feedbackMapper.deleteById(feedbackId);
        model.addAttribute("msg", "成功删除数据");
        System.out.println("--------成功删除数据-222--------");

        PageInfo<Feedback> pageData = feedbackService.pageQuery(null, null,null, 1, 4);
        // 将数据放到model
        model.addAttribute("pageInfo", pageData);
        System.out.println("--------显示意见反馈信息---------");
        return "forward:/feedback/feedbackList.jsp";// 转到演出信息页面展示

    }


    @RequestMapping("/viewFeedback")
    public String view(Integer feedbackId, Model model) {
        // 根据编号去查询文章信息
        Feedback feedback = feedbackMapper.selectById(feedbackId);
        // 将查询的博主文章数据放入model中
        model.addAttribute("obj", feedback);
        return "forward:/feedback/view.jsp";// 跳转显示页面
    }
}
