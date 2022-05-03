package com.example.demo.service;

import com.example.demo.Mapper.FeedbackMapper;
import com.example.demo.entity.Feedback;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackMapper feedbackMapper;


    public List<Feedback> getFeedbackList() {
        return feedbackMapper.selectList(null);
    }


    public List<Feedback> getFeedbackByUserId(String userId) {
        return feedbackMapper.findByUserId(userId);
    }

    public boolean addFeedback(Feedback feedback) {
        if(feedback.getFeedback()!=null && !"".equals(feedback.getFeedback())){
            try{
                int effectedNum = feedbackMapper.insert(feedback);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("插入意见反馈失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入意见反馈失败"+e.getMessage());
            }
        }else{
            throw new RuntimeException("意见反馈不能为空！");
        }
    }


    public boolean deleteFeedback(int feedbackId) {
        if(feedbackId>0){
            try{
                int effectedNum = feedbackMapper.deleteById(feedbackId);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("删除意见反馈失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入意见反馈失败"+e.getMessage());
            }
        }else {
            throw new RuntimeException("意见反馈不能为空！");
        }
    }


    public PageInfo<Feedback> pageQuery(Integer feedbackId, String feedbackType, String feedback, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Map<String, Object> map = new HashMap<>();
        if(feedbackId!=null){
            map.put("feedback_id",feedbackId);
        }
        if (feedbackType!=null && !feedbackType.isEmpty()){
            map.put("feedback_type",feedbackType);
        }
        if(feedback!=null && !feedback.isEmpty()) {
            map.put("feedback", feedback);
        }
        List<Feedback> all = feedbackMapper.selectByMap(map);
        return new PageInfo<>(all);
    }
}
