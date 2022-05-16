package io.sutsaehpeh.aqbp.common.redis.key.sysuser;

import lombok.Getter;

@Getter
public enum UserServiceKeyEnum {

    LOGGED_IN_USER_PREFIX("aqbp:user-service:user:login:", "已登录用户"),
    ;

    private final String key;

    private final String desc;

    UserServiceKeyEnum(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }


}
