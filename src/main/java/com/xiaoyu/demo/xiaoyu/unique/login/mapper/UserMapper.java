package com.xiaoyu.demo.xiaoyu.unique.login.mapper;

import com.xiaoyu.demo.xiaoyu.unique.login.domain.User;
import com.xiaoyu.demo.xiaoyu.unique.base.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends MyMapper<User> {

    @Select("SELECT * FROM user WHERE phone = #{phone} AND password = #{password}")
    User findByPhoneAndPassword(String phone,String password);

}
