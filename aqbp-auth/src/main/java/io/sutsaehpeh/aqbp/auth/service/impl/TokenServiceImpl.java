package io.sutsaehpeh.aqbp.auth.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.HmacAlgorithm;
import io.sutsaehpeh.aqbp.auth.constant.AuthConst;
import io.sutsaehpeh.aqbp.auth.service.TokenService;
import io.sutsaehpeh.aqbp.auth.util.JwtUtil;
import io.sutsaehpeh.aqbp.common.model.LoginUser;
import io.sutsaehpeh.aqbp.common.redis.RedisClient;
import io.sutsaehpeh.aqbp.common.redis.key.sysuser.UserServiceKeyEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private JwtUtil jwtUtil;


    @Autowired
    private RedisClient redisClient;

    @Override
    public LoginUser getLoginUser(String token) {
        Map<String, Object> map = jwtUtil.parseToken(token);
        String userKey = (String) map.get(AuthConst.USER_KEY);
        if (StrUtil.isEmpty(userKey)) {
            return new LoginUser();
        }
        String key = UserServiceKeyEnum.LOGGED_IN_USER_PREFIX.getKey() + userKey;
        LoginUser user = Optional.ofNullable(redisClient.get(key, LoginUser.class))
                .orElseGet(LoginUser::new);
        if (ObjectUtil.isNotNull(user.getUserId())) {
            renew(user);
        }
        return user;
    }

    @Override
    public String createToken(LoginUser user) {
        String key = UUID.randomUUID(true).toString();
        user.setKey(key);
        Date expireAt = DateUtil.offsetHour(new Date(), AuthConst.TOKEN_EXPIRE_TIME_IN_HOUR.intValue());
        user.setExpireAt(expireAt);
        String loginKey = UserServiceKeyEnum.LOGGED_IN_USER_PREFIX.getKey() + key;
        redisClient.set(loginKey, user, AuthConst.TOKEN_EXPIRE_TIME_IN_MILLISECONDS, TimeUnit.MILLISECONDS);
        Long userId = user.getUserId();
        String username = user.getUsername();
        String email = user.getEmail();
        Map<String, Object> headers = new HashMap<>();
        headers.put(AuthConst.ALGORITHM, HmacAlgorithm.HmacSHA256);
        Map<String, Object> payloads = new HashMap<>();
        payloads.put(AuthConst.USER_KEY, key);
        payloads.put(AuthConst.USER_ID, userId);
        payloads.put(AuthConst.USER_NAME, username);
        payloads.put(AuthConst.EMAIL, email);
        return jwtUtil.createToken(headers, payloads);
    }

    @Override
    public Boolean verifyToken(String token) {
        return jwtUtil.verifyToken(token);
    }

    private void renew(LoginUser user) {
        long current = System.currentTimeMillis();
        Date expireAt = user.getExpireAt();
        long expireAtInMilliseconds = expireAt.getTime();
        if (expireAtInMilliseconds - current <= AuthConst.TOKEN_REFRESH_TIME_IN_MILLISECONDS) {
            Date newExpireAt = DateUtil.offsetHour(expireAt, AuthConst.TOKEN_EXPIRE_TIME_IN_HOUR.intValue());
            user.setExpireAt(newExpireAt);
            String loginKey = UserServiceKeyEnum.LOGGED_IN_USER_PREFIX.getKey() + user.getKey();
            redisClient.expire(loginKey, AuthConst.TOKEN_EXPIRE_TIME_IN_MILLISECONDS);
        }
    }


}
