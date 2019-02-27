package com.xiaoyu.demo.xiaoyu.unique.login.exception;

import lombok.Data;

@Data
public class MyException extends RuntimeException {

    private Integer code;

    public MyException(String message){
        super(message);
    }

    public MyException(Integer code,String message){
        super(message);
        this.code = code;
    }
}
