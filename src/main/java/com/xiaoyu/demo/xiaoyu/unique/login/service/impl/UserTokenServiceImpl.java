package com.xiaoyu.demo.xiaoyu.unique.login.service.impl;

import com.xiaoyu.demo.xiaoyu.unique.login.domain.UserToken;
import com.xiaoyu.demo.xiaoyu.unique.login.exception.MyException;
import com.xiaoyu.demo.xiaoyu.unique.login.mapper.UserTokenMapper;
import com.xiaoyu.demo.xiaoyu.unique.login.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class UserTokenServiceImpl implements UserTokenService {

    @Autowired
    private UserTokenMapper mapper;

    @Override
    public UserToken findUsableToken(Long userId, String loginType) {
        if(StringUtils.isEmpty(userId) || StringUtils.isEmpty(loginType))
            throw new MyException(40001,"参数不完整");
        return mapper.findByUserIdAndLoginType(userId,loginType);
    }

    @Transactional
    @Override
    public void disableByToken(String token) {
        if(StringUtils.isEmpty(token))
            throw new MyException(40001,"参数不完整");
        mapper.disableByToken(token);
    }

    @Override
    @Transactional
    public void add(UserToken userToken) {
        int i = mapper.insert(userToken);
        if(1 != i)
            throw new MyException(50001,"添加token失败");
    }
}
