package com.sir.springbootdemo.util;

import com.sir.springbootdemo.ResultVo.Result;

public class ResultUtils {
    public static Result returnFail(){
        return new Result("101","错误");
    }

    public static Result returnFail(String msg){
        return new Result("101",msg);
    }

    public static Result<String> returnSuccess(){
        return new Result("201","成功");
    }

    public static Result returnSuccess(String msg){
        return new Result("201",msg);
    }

    public static Result returnDataSuccess(Object data){
        return new Result("201",data);
    }
}
