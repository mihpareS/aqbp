package io.sutsaehpeh.aqbp.auth.service;

import io.sutsaehpeh.aqbp.common.model.LoginUser;

public interface TokenService {

    LoginUser getLoginUser(String token);

    String createToken(LoginUser user);

    Boolean verifyToken(String token);

}
