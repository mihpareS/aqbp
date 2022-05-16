package io.sutsaehpeh.aqbp.auth.service;

import io.sutsaehpeh.aqbp.auth.request.LoginRequest;

public interface LoginService {

    String login(LoginRequest request);
}
