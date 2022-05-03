package com.example.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Order;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderMapper extends BaseMapper<Order> {
    @Select("select * from tb_order where user_id = #{userId}")
    List<Order> findByUserId(String userId);

    @Select("select * from tb_order where show_id = #{showId}")
    List<Order> findShowId(Integer showId);

    @Select("select max(order_id) from tb_order")
    Integer getMaxId();
}
