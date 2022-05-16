package io.sutsaehpeh.aqbp.auth.constant;

public class AuthConst {

    private AuthConst() {
    }

    public static final String ALGORITHM = "algorithm";

    public static final String USER_KEY = "user_key";

    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "username";

    public static final String EMAIL = "email";

    public static final Long TOKEN_EXPIRE_TIME_IN_HOUR = 1L;

    public static final Long TOKEN_EXPIRE_TIME_IN_MILLISECONDS = 60 * 60 * 1000L;

    public static final Long TOKEN_REFRESH_TIME_IN_MILLISECONDS = 10 * 60 * 1000L;


}
