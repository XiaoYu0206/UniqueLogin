package com.xiaoyu.demo.xiaoyu.unique.login.service;

import com.xiaoyu.demo.xiaoyu.unique.login.domain.UserToken;

public interface UserTokenService {

    /**
     * 查找可用token
     *
     * @param userId
     * @param loginType
     * @return 如果有，返回UserToken实例，如果没有，返回null
     */
    UserToken findUsableToken(Long userId,String loginType);

    /**
     * 让某个token不可用
     * @param token
     */
    void disableByToken(String token);

    /**
     * 新增一条数据
     * @param userToken
     */
    void add(UserToken userToken);
}
