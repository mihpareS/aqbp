package io.sutsaehpeh.aqbp.auth.enums;

import lombok.Getter;

@Getter
public enum RedisKeyPrefixEnum {

    LOGGED_ON("user:login:", "已登录用户"),
    ;

    private final String prefix;

    private final String desc;

    RedisKeyPrefixEnum(String prefix, String desc) {
        this.prefix = prefix;
        this.desc = desc;
    }
}
