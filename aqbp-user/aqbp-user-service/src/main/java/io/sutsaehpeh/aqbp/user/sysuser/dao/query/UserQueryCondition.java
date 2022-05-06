package io.sutsaehpeh.aqbp.user.sysuser.dao.query;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserQueryCondition {

    private Long userId;

    private String username;

    private String password;

    private String email;

    private String userAvatar;

    private Integer userStatus;

    private Date registerStartDate;

    private Date registerEndDate;

    private Date gmtCreated;

    private Date gmtModified;

    private Integer deleteFlag;

    private Integer pageNumber;

    private Integer pageSize;

    private List<String> sortBy;

    private String direction;
}
