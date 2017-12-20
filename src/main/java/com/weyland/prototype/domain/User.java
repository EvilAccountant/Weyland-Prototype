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
@Table(name="user_table")
public class User {

    @Id
    @GenericGenerator(name="userIdGen", strategy="uuid") //生成32位UUID
    @GeneratedValue(generator="userIdGen")
    @Column(name = "id",length = 32,nullable = false)
    private String userId;


    @Column(name = "user_account")
    private String userAccount;


    @Column(name = "user_password")
    private String userPassword;


    @Column(name = "user_email")
    private String userEmail;


    @Column(name = "user_birth")
    private String userBirth;


    @Column(name = "user_gender")
    private String userGender;


    @Column(name = "user_name")
    private String userName;



}
