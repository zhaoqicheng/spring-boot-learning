package com.example.learning.common.exception;

import com.example.learning.common.result.Result;
import com.example.learning.common.result.ResultEnum;
import com.example.learning.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhaoqicheng on 2017/5/2.
 *
 * 对于系统级的异常统一处理
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof DentalClinicException){
            DentalClinicException personException = (DentalClinicException) e;
            return ResultUtil.error(personException.getCode() , personException.getMessage());
        }else{
            LOGGER.info("【系统异常】：" + e);
            return ResultUtil.error(ResultEnum.UNKNOW_ERROR);
        }
    }
}
