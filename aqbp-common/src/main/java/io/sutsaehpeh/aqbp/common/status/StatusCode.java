package io.sutsaehpeh.aqbp.common.status;

import lombok.Getter;

@Getter
public enum StatusCode {

    OK("00000", "ok", "correct response"),
    CLIENT_ERROR("A0001", "client error", "client error"),
    REGISTER_NAME_ILLEGAL("A0002", "username illegal", "username illegal"),
    REGISTER_PASSWORD_ILLEGAL("A0003", "password illegal", "password illegal"),
    REGISTER_EMAIL_ILLEGAL("A0004", "email illegal", "email illegal"),
    USER_NOT_EXISTS("A0010", "user not exists", "user not exists"),

    SYSTEM_EXECUTION_ERROR("B0001", "system execution error", "system error"),
    REMOTE_INVOKE_ERROR("C0001", "remote invocation error", "remote error"),
    ;

    private String code;

    private String msg;

    private String desc;

    StatusCode(String code, String msg, String desc) {
        this.code = code;
        this.msg = msg;
        this.desc = desc;
    }

}
