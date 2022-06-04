package edu.ccsu.grade19.wu.cims.utility.http;

import lombok.Data;

import java.io.Serializable;

/**
 * 接口统一响应体
 * @author Haixin Wu
 * @since 1.0
 */
@Data
public class RestResponse<T> implements Serializable {
    private int code;
    private String msg;
    private T response;

    public RestResponse(SystemCode systemCode) {
        this.code = systemCode.code;
        this.msg = systemCode.message;
    }

    public RestResponse(int code, String message) {
        this.code = code;
        this.msg = message;
    }

    public RestResponse(int code, String message, T response) {
        this.code = code;
        this.msg = message;
        this.response = response;
    }

    public static <F> RestResponse<F> ok() {
        return ok(null);
    }

    public static <F> RestResponse<F> ok(F response) {
        SystemCode systemCode = SystemCode.OK;
        return new RestResponse<>(systemCode.getCode(), systemCode.getMessage(), response);
    }

    public static <F> RestResponse<F> failure() {
        return failure(null);
    }

    public static <F> RestResponse<F> failure(F response) {
        SystemCode systemCode = SystemCode.Failure;
        return new RestResponse<>(systemCode.getCode(), systemCode.getMessage(), response);
    }
}
