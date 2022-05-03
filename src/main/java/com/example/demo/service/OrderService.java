package com.example.demo.service;

import com.example.demo.Mapper.OrderMapper;
import com.example.demo.entity.Order;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;


    public List<Order> getOrderList() {
        return orderMapper.selectList(null);
    }


    public List<Order> getOrderByShowId(Integer showId) {
        return orderMapper.findShowId(showId);
    }

    public List<Order> getOrderByUserId(String userId) {
        return orderMapper.findByUserId(userId);
    }


    public Order getOrderById(Integer orderId) {
        return orderMapper.selectById(orderId);
    }


    public boolean addOrder(Order order) {
        if (order.getSeatId() != null) {
            try {
                order.setOrderId(orderMapper.getMaxId()+1);
                int effectedNum = orderMapper.insert(order);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入订单信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入订单信息失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("订单信息不能为空");
        }
    }

    public boolean deleteOrder(Integer orderId) {
        if (orderId != null) {
            try {
                int effectedNum = orderMapper.deleteById(orderId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除订单信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除订单信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("订单ID不能为空！");
        }
    }

    public PageInfo<Order> pageQuery(Integer orderId, String userId, Integer showId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Map<String, Object> map = new HashMap<>();
        if (orderId != null) {
            map.put("order_id", orderId);
        }
        if (userId != null && !userId.isEmpty()) {
            map.put("user_id", userId);
        }
        if (showId != null) {
            map.put("show_id", showId);
        }

        List<Order> all = orderMapper.selectByMap(map);
        return new PageInfo<>(all);
    }
}
