package io.sutsaehpeh.aqbp.auth.web.controller;

import io.sutsaehpeh.aqbp.auth.request.LoginRequest;
import io.sutsaehpeh.aqbp.auth.service.LoginService;
import io.sutsaehpeh.aqbp.common.response.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ApiResult<String> login(@RequestBody LoginRequest request) {
        return ApiResult.ok(loginService.login(request));
    }
}
