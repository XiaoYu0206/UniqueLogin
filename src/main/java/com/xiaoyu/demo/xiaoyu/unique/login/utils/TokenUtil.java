package com.xiaoyu.demo.xiaoyu.unique.login.utils;

import com.xiaoyu.demo.xiaoyu.unique.login.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Component
public class TokenUtil {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 生成token
     * @param keyPrefix
     * @param redisValue
     * @param time
     * @return
     */
    public String createToken(String keyPrefix,String redisValue,Long time){
        if(StringUtils.isEmpty(redisValue))
            throw new MyException(402,"redisValue is null");
        String token = keyPrefix + UUID.randomUUID().toString().replace("-", "");
        redisTemplate.opsForValue().set(token,redisValue,time);
        return token;
    }

    public void removeToken(String token){
        if(StringUtils.isEmpty(token))
            return;
        if(redisTemplate.hasKey(token))
            redisTemplate.delete(token);

    }
}
