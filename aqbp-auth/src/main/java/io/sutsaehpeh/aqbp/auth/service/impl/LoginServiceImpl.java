package io.sutsaehpeh.aqbp.auth.service.impl;

import io.sutsaehpeh.aqbp.auth.enums.LoginType;
import io.sutsaehpeh.aqbp.auth.model.AuthUser;
import io.sutsaehpeh.aqbp.auth.request.LoginRequest;
import io.sutsaehpeh.aqbp.auth.service.LoginService;
import io.sutsaehpeh.aqbp.auth.service.TokenService;
import io.sutsaehpeh.aqbp.common.exception.BusinessException;
import io.sutsaehpeh.aqbp.common.redis.RedisClient;
import io.sutsaehpeh.aqbp.common.status.StatusCode;
import io.sutsaehpeh.aqbp.user.api.SysUserRpcApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SysUserRpcApi sysUserRpcApi;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private RedisClient redisClient;


    @Override
    public String login(@RequestBody LoginRequest request) {
        LoginType type = LoginType.getType(request.getLoginType());
        String queryString = null;
        if (type == LoginType.USERNAME) {
            queryString = request.getUsername();
        } else {
            queryString = request.getEmail();
        }
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(queryString, request.getPassword());
        try {
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            AuthUser user = (AuthUser) authentication.getPrincipal();
            return tokenService.createToken(user.getLoginUser());
        } catch (BadCredentialsException e) {
            throw new BusinessException(StatusCode.USERNAME_OR_PASSWORD_INCORRECT);
        }
    }
}
