package io.sutsaehpeh.aqbp.user.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysUserDTO implements Serializable {

    private Long userId;

    private String username;

    private String password;

    private String email;

    private String userAvatar;

    private Integer userStatus;

    private Integer userType;

    private Date registerDate;

    private Date gmtCreated;

    private Date gmtModified;

}
