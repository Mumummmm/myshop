package com.spike.my.shop.commons.dto;

import java.io.Serializable;

public class BaseResult implements Serializable {
    private Integer status;
    private String message;

    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAIL = 500;

    public static BaseResult success() {
        return createBaseResult(STATUS_SUCCESS, "成功");
    }
    public static BaseResult success(String message) {
        return createBaseResult(STATUS_SUCCESS, message);
    }
    public static BaseResult fail() {
        return createBaseResult(STATUS_FAIL, "失败");
    }
    public static BaseResult fail(String message) {
        return createBaseResult(STATUS_FAIL, message);
    }
    public static BaseResult fail(Integer status, String message) {
        return createBaseResult(status, message);
    }

    public static BaseResult createBaseResult(Integer status, String message) {
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        return baseResult;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
