package com.xiaoyu.demo.xiaoyu.unique.login.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 登录请求体
 * @author xiaoyu
 * @version 1.0
 */
@Data
public class UserLoginForm {

    /**
     * 手机号
     */
    @NotBlank(message = "缺少手机号码")
    private String phone;

    /**
     * 密码
     */
    @NotBlank(message = "缺少密码")
    private String password;

    /**
     * 登录类型
     */
    @NotBlank(message = "缺少登录类型")
    private String loginType;

    /**
     * 设备信息
     */
    @NotBlank(message = "缺少设备信息")
    private String deviceInfo;
}
