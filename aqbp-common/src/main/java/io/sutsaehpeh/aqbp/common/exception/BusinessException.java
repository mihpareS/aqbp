package io.sutsaehpeh.aqbp.common.exception;

import io.sutsaehpeh.aqbp.common.status.StatusCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final String code;

    public BusinessException(StatusCode statusCode) {
        super(statusCode.getMsg());
        this.code = statusCode.getCode();
    }

    public BusinessException(String msg) {
        super(msg);
        this.code = StatusCode.SYSTEM_EXECUTION_ERROR.getCode();
    }

    public BusinessException(String message, String code) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }

}
