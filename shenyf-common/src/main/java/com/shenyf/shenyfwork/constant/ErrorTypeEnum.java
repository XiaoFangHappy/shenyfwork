package com.shenyf.shenyfwork.constant;

public enum ErrorTypeEnum {
    //资源参数问题
    PARAM_INVALID("1001", "参数不合法"),


    //系统基本码
    ERROR("9999", "系统异常"),
    SUCCESS("0000", "成功");


    private String code;

    private String message;

    ErrorTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
