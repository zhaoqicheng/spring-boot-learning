package com.example.learning.common.result;

/**
 * Created by zhaoqicheng on 2017/3/25.
 * 自定义异常信息枚举类
 */
public enum ResultEnum {

    UNKNOW_ERROR("-1" , "未知错误") ,
    PARAM_ERROR("101","参数非法"),
    ERROR_USER("102","用户名或者密码错误"),
    ERROR_REGISTER("103","用户账号未注册"),
    ERROR_EXPIRE("104","用户邀请码过期，请联系纽罗口腔客服重新获取邀请码！！！"),
    ERROR_DELECTTENANT("105","登录用户已被停用！请联系纽罗口腔客服！！！"),
    ERROR_DELECTUSER("106","登录用户已被停用！请联系主账号开通！！！"),
    ERROR_LOGIN("107","用户未登录"),
    ERROR_TOKEN_EXPIRE("108","用户token过期"),
    ERROR_TOKEN("109","token非法"),
    ERROR_ERROR_SMS("110","发送短信失败,请稍后再试"),
    ERROR_ERROR_IDENTIFIY_SMS("111","验证码错误，请核对！");

    private String code;

    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
