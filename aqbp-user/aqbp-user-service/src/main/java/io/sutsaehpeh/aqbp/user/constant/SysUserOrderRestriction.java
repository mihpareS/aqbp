package io.sutsaehpeh.aqbp.user.constant;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SysUserOrderRestriction {

    private SysUserOrderRestriction() {
    }

    public static final String USER_ID = "userId";

    public static final String USERNAME = "username";

    public static final String EMAIL = "email";

    public static final String REGISTER_DATE = "registerDate";


    public static final List<String> Restrictions = Stream.of(USER_ID, USERNAME, EMAIL, REGISTER_DATE).collect(Collectors.toUnmodifiableList());

}
