package io.sutsaehpeh.aqbp.common.response;

import io.sutsaehpeh.aqbp.common.status.StatusCode;
import lombok.Data;

import java.io.Serializable;

@Data
public class ApiResult<T> implements Serializable {

    private String code;

    private T data;

    private String msg;

    public boolean isSuccess() {
        return StatusCode.OK.getCode().equals(code);
    }


    public static <T> ApiResult<T> ok() {
        return createByOk();
    }

    public static <T> ApiResult<T> ok(T data) {
        ApiResult<T> result = createByOk();
        result.data = data;
        return result;
    }

    public static <T> ApiResult<T> ok(String code, T data) {
        ApiResult<T> result = createByOk();
        result.code = code;
        result.data = data;
        return result;
    }

    public static <T> ApiResult<T> ok(String code, String msg) {
        ApiResult<T> result = createByOk();
        result.code = code;
        result.msg = msg;
        return result;
    }

    public static <T> ApiResult<T> error() {
        return createByError();
    }

    public static <T> ApiResult<T> error(String msg) {
        ApiResult<T> result = createByError();
        result.code = msg;
        return result;
    }

    public static <T> ApiResult<T> error(String code, String msg) {
        ApiResult<T> result = createByError();
        result.code = code;
        result.msg = msg;
        return result;
    }


    private static <T> ApiResult<T> createByOk() {
        ApiResult<T> result = new ApiResult<>();
        result.code = StatusCode.OK.getCode();
        result.msg = StatusCode.OK.getMsg();
        return result;
    }

    private static <T> ApiResult<T> createByError() {
        ApiResult<T> result = new ApiResult<>();
        result.code = StatusCode.SYSTEM_EXECUTION_ERROR.getCode();
        result.msg = StatusCode.SYSTEM_EXECUTION_ERROR.getMsg();
        return result;
    }


}
