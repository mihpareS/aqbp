package io.sutsaehpeh.aqbp.user.web.aop;

import io.sutsaehpeh.aqbp.common.exception.BusinessException;
import io.sutsaehpeh.aqbp.common.response.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ApiResult<String> internalServerErrorHandler(Exception e) {
        log.error(e.getMessage(), e);
        return ApiResult.error();
    }

    @ExceptionHandler(value = { BusinessException.class })
    public ApiResult<String> businessExceptionHandler(BusinessException e) {
        log.error(e.getMessage(), e);
        return ApiResult.error(e.getCode(), e.getMessage());
    }

}
