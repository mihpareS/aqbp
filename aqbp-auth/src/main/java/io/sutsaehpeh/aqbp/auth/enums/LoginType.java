package io.sutsaehpeh.aqbp.auth.enums;

import cn.hutool.core.util.ObjectUtil;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum LoginType {

    USERNAME(1, "login by username"),
    EMAIL(2, "login by email"),

    ;

    private static final Map<Integer, LoginType> map = new HashMap<>();

    static {
        for (LoginType value : values()) {
            map.put(value.type, value);
        }
    }

    private final Integer type;

    private final String desc;

    LoginType(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static LoginType getType(Integer type) {
        if (ObjectUtil.isNull(type)) {
            type = USERNAME.getType();
        }
        return map.getOrDefault(type, LoginType.USERNAME);
    }

}
