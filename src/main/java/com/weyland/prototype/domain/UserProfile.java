package com.weyland.prototype.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* Creator: LayWin
 * \* CreateTime: 2017/12/20 21:36
 * \* Description:
 * \
 */
@Entity
//实现属性映射数据库字段
@Table(name="USER_PROFILE")
public class UserProfile extends BaseEntity{

    //昵称
    @Column(name = "user_name")
    private String userName;
    //头像
    @Column(name = "user_avatar")
    private String userAvatar;
    //出生日期
    @Column(name = "user_birth")
    private String userBirth;
    //性别
    @Column(name = "user_sex")
    private String userSex;
    //邮箱
    @Column(name = "user_email")
    private String userEmail;
    //电话
    @Column(name = "user_phone")
    private String userPhone;
    //地址
    @Column(name = "user_location")
    private String userLocation;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }
}
