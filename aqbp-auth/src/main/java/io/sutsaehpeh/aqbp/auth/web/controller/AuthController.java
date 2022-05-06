package io.sutsaehpeh.aqbp.auth.web.controller;

import io.sutsaehpeh.aqbp.auth.request.LoginRequest;
import io.sutsaehpeh.aqbp.common.response.ApiResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/login")
    public ApiResult<String> login(@RequestBody LoginRequest request) {
        return ApiResult.ok();
    }
}
