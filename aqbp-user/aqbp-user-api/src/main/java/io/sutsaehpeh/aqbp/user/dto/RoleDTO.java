package io.sutsaehpeh.aqbp.user.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class RoleDTO implements Serializable {
    private final Long roleId;
    private final String roleKey;
    private final Integer roleType;
    private final String roleName;
    private final Integer status;
    private final Integer weight;
    private final String roleDesc;
    private final Instant gmtCreated;
    private final Instant gmtModified;
}
