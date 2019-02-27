package com.xiaoyu.demo.xiaoyu.unique.login.mapper;

import com.xiaoyu.demo.xiaoyu.unique.login.domain.UserToken;
import com.xiaoyu.demo.xiaoyu.unique.base.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserTokenMapper extends MyMapper<UserToken> {

    /**
     * 根据用户ID和登录类型查询当前可用的token记录
     * @param userId
     * @param loginType
     * @return
     */
    @Select("SELECT * FROM user_token WHERE user_id = #{userId} AND login_type = #{loginType} AND is_availability = 1")
    UserToken findByUserIdAndLoginType(@Param("userId") Long userId,@Param("loginType") String loginType);

    /**
     * 将某个token设为不可用
     * @param token
     */
    @Update("UPDATE user_token SET is_availability = 0 WHERE token = #{token}")
    void disableByToken(@Param("token") String token);

}
