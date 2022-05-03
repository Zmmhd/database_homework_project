package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;

public class Select {
    private String userId;
    private String showId;
    private String showName;
    private String showTime;
    private Integer seatId;

    public Select() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
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

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    @Override
    public String toString() {
        return "Select{" +
                "userId='" + userId + '\'' +
                ", showId='" + showId + '\'' +
                ", showName='" + showName + '\'' +
                ", showTime='" + showTime + '\'' +
                ", seatId=" + seatId +
                '}';
    }
}
