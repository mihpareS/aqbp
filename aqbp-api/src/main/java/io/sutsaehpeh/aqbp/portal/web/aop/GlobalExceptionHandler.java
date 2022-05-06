package io.sutsaehpeh.aqbp.portal.web.aop;

import io.sutsaehpeh.aqbp.common.response.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ApiResult<String> internalServerErrorHandler(Exception e) {
        log.error(e.getMessage(), e);
        return ApiResult.error();
    }
}
