package com.xiaoyu.demo.xiaoyu.unique.login.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "user_token")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserToken {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户token
     */
    @Column(name = "token")
    private String token;

    /**
     * 登录类型
     */
    @Column(name = "login_type")
    private String loginType;

    /**
     * 设备信息
     */
    @Column(name = "device_info")
    private String deviceInfo;

    /**
     * 是否失效
     */
    @Column(name = "is_availability")
    private Boolean isAvailability;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;
}
