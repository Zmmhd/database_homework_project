package com.example.demo.service;

import com.example.demo.Mapper.CommentMapper;
import com.example.demo.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;


    public List<Comment> getCommentList() {
        return commentMapper.selectList(null);
    }

    public List<Comment> getCommentByUserId(String userId) {
        return commentMapper.findByUserId(userId);
    }

    public List<Comment> getCommentByShowId(int showId) {
        return commentMapper.findByShowId(showId);
    }

    public boolean addComment(Comment comment) {
        if(comment.getComment()!=null && !"".equals(comment.getComment())){
            try{
                comment.setCommentId(commentMapper.getMaxId()+1);
                int effectedNum = commentMapper.insert(comment);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("插入评论失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入评论失败"+e.getMessage());
            }
        }else{
            throw new RuntimeException("评论不能为空！");
        }
    }

    public boolean deleteComment(int commentId) {
        if(commentId>0){
            try{
                int effectedNum = commentMapper.deleteById(commentId);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("删除评论失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入评论失败"+e.getMessage());
            }
        }else {
            throw new RuntimeException("评论不能为空！");
        }
    }
}
