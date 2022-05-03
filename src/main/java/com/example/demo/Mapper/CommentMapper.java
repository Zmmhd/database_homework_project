package com.example.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Comment;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentMapper extends BaseMapper<Comment> {

    @Select("select * from tb_comment where show_id = #{showId}")
    List<Comment> findByShowId(int showId);

    @Select("select * from tb_comment where user_id = #{userId}")
    List<Comment> findByUserId(String userId);

    @Select("select max(comment_id) from tb_comment")
    Integer getMaxId();
}
