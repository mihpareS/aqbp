package io.sutsaehpeh.aqbp.user.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class MenuDTO implements Serializable {
    private final Long menuId;
    private final String menuName;
    private final String menuKey;
    private final String component;
    private final Long parentId;
    private final String target;
    private final Integer weight;
    private final Integer menuType;
    private final Integer visible;
    private final String path;
    private final String redirect;
    private final Instant gmtCreated;
    private final Instant gmtModified;
}
