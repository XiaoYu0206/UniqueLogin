package com.xiaoyu.demo.xiaoyu.unique.login.response;

public class ResultUtil {

    public static ResultVo success(Object o){
        return success(o, "success");
    }

    public static ResultVo success(Object o,String msg){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg(msg);
        resultVo.setData(o);
        return resultVo;
    }

    public static ResultVo success(){
        return success(null,"success");
    }

    public static ResultVo error(Integer code,String msg){
        return error(code,msg,null);
    }

    public static ResultVo error(Integer code,String msg,Object o){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        resultVo.setData(o);
        return resultVo;
    }
}
