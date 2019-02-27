package com.xiaoyu.demo.xiaoyu.unique.login.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "name")
    private String name;

    /**
     * 手机号码
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;
}
