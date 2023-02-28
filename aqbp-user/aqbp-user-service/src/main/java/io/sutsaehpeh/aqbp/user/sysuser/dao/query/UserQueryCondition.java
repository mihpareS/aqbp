package io.sutsaehpeh.aqbp.user.sysuser.dao.query;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserQueryCondition {

    private Long userId;

    private String queryString;

    private String username;

    private String password;

    private String email;

    private String userAvatar;

    private Integer userStatus;

    private List<Date> dates;

    private Date gmtCreated;

    private Date gmtModified;

    private Integer deleteFlag;

    private Integer pageNumber;

    private Integer pageSize;

    private List<String> sortBy;

    private String direction;
}
