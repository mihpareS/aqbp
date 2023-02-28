package io.sutsaehpeh.aqbp.user.request.role;

import lombok.Data;

@Data
public class RoleCreateRequest {

    private String roleKey;
    private Integer roleType;
    private String roleName;
    private Integer status;
    private Integer weight;
    private String roleDesc;
}
