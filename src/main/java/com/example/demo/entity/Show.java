package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.stereotype.Repository;

@TableName("tb_show")
@Repository
public class Show {
    @TableId(value = "show_id")
    private Integer showId;
    private String showName;
    private String showType;
    private String showSite;
    private String showTime;
    private String showIntroduction;
    private Integer total;
    private Integer forSell;
    private Integer price;
    private String imgUrl;

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public String getShowSite() {
        return showSite;
    }

    public void setShowSite(String showSite) {
        this.showSite = showSite;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public String getShowIntroduction() {
        return showIntroduction;
    }

    public void setShowIntroduction(String showIntroduction) {
        this.showIntroduction = showIntroduction;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getForSell() {
        return forSell;
    }

    public void setForSell(Integer forSell) {
        this.forSell = forSell;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "Show{" +
                "showId=" + showId +
                ", showName='" + showName + '\'' +
                ", showType='" + showType + '\'' +
                ", showSite='" + showSite + '\'' +
                ", showTime='" + showTime + '\'' +
                ", showIntroduction='" + showIntroduction + '\'' +
                ", total=" + total +
                ", forSell=" + forSell +
                ", price=" + price +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
