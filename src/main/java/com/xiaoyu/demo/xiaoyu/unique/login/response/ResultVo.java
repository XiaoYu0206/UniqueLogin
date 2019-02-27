package com.xiaoyu.demo.xiaoyu.unique.login.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVo<T> implements Serializable {

    private static final long serialVersionUID = 3068837394742385883L;

    private Integer code;

    private String msg;

    private T data;
}
