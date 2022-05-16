package io.sutsaehpeh.aqbp.common.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LoginUser implements Serializable {

    private String key;

    private Long userId;

    private String username;

    private String password;

    private String email;

    private Date expireAt;


}
