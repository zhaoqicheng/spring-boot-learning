package com.example.learning.utils;


import com.example.learning.common.result.Result;
import com.example.learning.common.result.ResultEnum;

/**
 * Created by zhaoqicheng on 2017/3/24.
 */
@SuppressWarnings(value = "unchecked")
public class ResultUtil {

    public static Result success(Object obj){
        Result result = new Result();
        result.setCode("200");
        result.setMsg("成功");
        result.setData(obj);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(String code , String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    public static Result error(ResultEnum resultEnum){
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(null);
        return result;
    }
}
