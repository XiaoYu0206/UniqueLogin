package com.xiaoyu.demo.xiaoyu.unique.login.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyu.demo.xiaoyu.unique.login.constants.LoginConstants;
import com.xiaoyu.demo.xiaoyu.unique.login.domain.User;
import com.xiaoyu.demo.xiaoyu.unique.login.domain.UserToken;
import com.xiaoyu.demo.xiaoyu.unique.login.exception.MyException;
import com.xiaoyu.demo.xiaoyu.unique.login.form.UserLoginForm;
import com.xiaoyu.demo.xiaoyu.unique.login.mapper.UserMapper;
import com.xiaoyu.demo.xiaoyu.unique.login.response.ResultUtil;
import com.xiaoyu.demo.xiaoyu.unique.login.response.ResultVo;
import com.xiaoyu.demo.xiaoyu.unique.login.service.UserService;
import com.xiaoyu.demo.xiaoyu.unique.login.service.UserTokenService;
import com.xiaoyu.demo.xiaoyu.unique.login.utils.MD5Util;
import com.xiaoyu.demo.xiaoyu.unique.login.utils.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private  TokenUtil tokenUtil;
    @Autowired
    private UserTokenService userTokenService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    @Transactional
    public UserToken login(UserLoginForm form) {
        User user = userMapper.findByPhoneAndPassword(form.getPhone(), MD5Util.md5(form.getPassword()));
        if(null == user)
            throw new MyException(401,"用户名密码错误");
        //根据userId+loginType查询当前登录类型账号之前是否有登录过
        UserToken usableToken = userTokenService.findUsableToken(user.getId(), form.getLoginType());
        if(null != usableToken){
            //如果有登录过，把之前的token不可用
            userTokenService.disableByToken(usableToken.getToken());
            stringRedisTemplate.opsForValue().set(user.getId()+"removeToken",usableToken.getToken(),1l, TimeUnit.MINUTES);
        }
        String keyPrefix = LoginConstants.MEMBER_TOKEN_KEYPREFIX+form.getLoginType();
        String token = tokenUtil.createToken(keyPrefix, user.getId() + "", LoginConstants.MEMBER_LOGIN_TOKEN_TIME);
        //插入一条新的token到数据库
        UserToken userToken = UserToken.builder()
                .deviceInfo(form.getDeviceInfo())
                .loginType(form.getLoginType())
                .isAvailability(Boolean.TRUE)
                .createTime(new Date())
                .updateTime(new Date())
                .userId(user.getId())
                .token(token)
                .build();
        userTokenService.add(userToken);
        return userToken;
    }
}
