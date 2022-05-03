package com.example.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.stereotype.Repository;

@TableName("tb_order")
@Repository
public class Order {
    @TableId(value = "order_id")
    private Integer orderId;
    private String userId;
    private Integer showId;
    private Integer seatId;
    private String seatInfo;
    private String showName;
    private String showTime;


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public String getSeatInfo() {
        return seatInfo;
    }

    public void setSeatInfo(String seatInfo) {
        this.seatInfo = seatInfo;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }


    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId='" + userId + '\'' +
                ", showId=" + showId +
                ", seatId=" + seatId +
                ", seatInfo='" + seatInfo + '\'' +
                ", showName='" + showName + '\'' +
                ", showTime='" + showTime + '\'' +
                '}';
    }

    public Order(Integer orderId, String userId, Integer showId, Integer seatId, String seatInfo, String showName, String showTime) {
        this.orderId = orderId;
        this.userId = userId;
        this.showId = showId;
        this.seatId = seatId;
        this.seatInfo = seatInfo;
        this.showName = showName;
        this.showTime = showTime;
    }

    public Order() {
    }
}
