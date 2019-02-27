package com.xiaoyu.demo.xiaoyu.unique.login.service;

import com.xiaoyu.demo.xiaoyu.unique.login.domain.UserToken;
import com.xiaoyu.demo.xiaoyu.unique.login.form.UserLoginForm;

public interface UserService {

    /**
     * 用户登录
     * @param form
     * @return 返回token
     */
   UserToken login(UserLoginForm form);
}
