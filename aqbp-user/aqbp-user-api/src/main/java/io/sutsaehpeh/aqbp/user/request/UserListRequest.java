package io.sutsaehpeh.aqbp.user.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserListRequest implements Serializable {

    private Long userId;

    private String username;

    private String email;

    private Date registerStartDate;

    private Date registerEndDate;



}
