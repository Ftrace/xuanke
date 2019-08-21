package com.fyh.xuanke.base.result;

public enum ResultCode {

    //全局成功
    SUCCESS(200,"成功"),
    //全局失败
    FAIL(500,"失败"),
    /**
     * 跟用户有关的错误
     * USER_ 开头
     *
     * 错误码 500200 - 500299
     */
    USER_LOGIN_ERROR(500201,"登录失败，用户名或密码出错，请重新输入."),
    USER_HAS_EXISTED(500202,"用户已存在，请试试其他用户名。"),
    USER_NOT_LOGIN(500203,"用户未登录或登录已失效，请重新登录。");
    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
