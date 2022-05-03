package com.example.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Feedback;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FeedbackMapper extends BaseMapper<Feedback> {
    @Select("select * from tb_feedback where user_id = #{userId}")
    List<Feedback> findByUserId(String userId);
}
