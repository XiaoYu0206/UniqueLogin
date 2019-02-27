package com.xiaoyu.demo.xiaoyu.unique.login.handler;

import com.xiaoyu.demo.xiaoyu.unique.login.exception.MyException;
import com.xiaoyu.demo.xiaoyu.unique.login.response.ResultUtil;
import com.xiaoyu.demo.xiaoyu.unique.login.response.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
@Component
public class MyExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultVo handlerException(HttpServletRequest request,Exception e){
        log.error("【系统异常处理】{}",e);
        return ResultUtil.error(-1,e.getMessage());
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResultVo MyExceptionException(HttpServletRequest request,MyException e){
        log.error("【系统异常处理】{}",e);
        return ResultUtil.error(e.getCode(),e.getMessage());
    }
}
