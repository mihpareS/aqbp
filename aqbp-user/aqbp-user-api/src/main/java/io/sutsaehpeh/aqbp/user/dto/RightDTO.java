package io.sutsaehpeh.aqbp.user.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class RightDTO implements Serializable {
    private final Long rightId;
    private final String rightKey;
    private final String rightName;
    private final String rightDesc;
    private final Integer status;
    private final Integer weight;
    private final Instant gmtCreated;
    private final Instant gmtModified;
}
