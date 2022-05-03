package com.example.demo.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;

@TableName("tb_user")
@Repository
public class User {
    @NotBlank(message = "用户名不能为空")
    @TableId(value = "user_id")
    private String userId;
    private String nickname;
    private String gender;
    private String country;
    private String province;
    private String city;
    private String phoneNumber;
    private Integer age;
    private String email;
    private String hobby;
    private String introduction;
    private String address;
    private String password;

    public User() {
    }

    public User(@NotBlank(message = "用户名不能为空") String userId, String nickname, String gender, String country, String province, String city, String phoneNumber, Integer age, String email, String hobby, String introduction, String address, String password) {
        this.userId = userId;
        this.nickname = nickname;
        this.gender = gender;
        this.country = country;
        this.province = province;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
        this.hobby = hobby;
        this.introduction = introduction;
        this.address = address;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", nickname='" + nickname + '\'' +
                ", gender='" + gender + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", hobby='" + hobby + '\'' +
                ", introduction='" + introduction + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
