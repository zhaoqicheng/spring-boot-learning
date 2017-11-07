package com.example.learning.common.exception;

import com.example.learning.common.result.ResultEnum;

/**
 * Created by zhaoqicheng on 2017/4/24.
 */
public class DentalClinicException extends RuntimeException {


    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DentalClinicException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
