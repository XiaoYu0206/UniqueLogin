package com.xiaoyu.demo.xiaoyu.unique.login.api;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyu.demo.xiaoyu.unique.login.constants.LoginConstants;
import com.xiaoyu.demo.xiaoyu.unique.login.domain.UserToken;
import com.xiaoyu.demo.xiaoyu.unique.login.exception.MyException;
import com.xiaoyu.demo.xiaoyu.unique.login.form.UserLoginForm;
import com.xiaoyu.demo.xiaoyu.unique.login.response.ResultUtil;
import com.xiaoyu.demo.xiaoyu.unique.login.response.ResultVo;
import com.xiaoyu.demo.xiaoyu.unique.login.service.UserService;
import com.xiaoyu.demo.xiaoyu.unique.login.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 唯一登录解决方案测试Controller
 * @author xiaoyu
 */
@RestController
@RequestMapping("/xiaoyu/test")
public class LoginApiController {

    @Autowired
    private UserService userService;
    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 登录
     * @param form
     * @param bindingResult
     * @return
     */
    @PostMapping("login")
    public ResultVo login(@RequestBody @Valid UserLoginForm form, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors())
            throw new MyException(bindingResult.getFieldError().getDefaultMessage());
        checkLogin(form);
        UserToken userToken = userService.login(form);
        String s = stringRedisTemplate.opsForValue().get(userToken.getUserId() + "removeToken");
        tokenUtil.removeToken(s);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token",userToken.getToken());
        return ResultUtil.success(jsonObject);
    }

    public void checkLogin(UserLoginForm form){
        boolean flag = false;
        switch (form.getLoginType()){
            case LoginConstants.MEMBER_LOGIN_TYPE_ANDROID:
            case LoginConstants.MEMBER_LOGIN_TYPE_IOS:
            case LoginConstants.MEMBER_LOGIN_TYPE_PC:
                flag = true;
        }
        if(!flag)
            throw new MyException(40001,"登录类型有误");
    }
}
