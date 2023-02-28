package io.sutsaehpeh.aqbp.user.request.right;

import lombok.Data;

@Data
public class RightCreateRequest {

    private String rightKey;

    private String rightName;

    private String rightDesc;

    private Integer status;

    private Integer weight;
}
