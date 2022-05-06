package io.sutsaehpeh.aqbp.auth.enums;

import lombok.Getter;

@Getter
public enum LoginType {

    USERNAME(1, "login by username"),
    EMAIL(2, "login by email"),

    ;


    private final Integer type;

    private final String desc;

    LoginType(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

}
