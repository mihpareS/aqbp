package io.sutsaehpeh.aqbp.user.request.menu;

import lombok.Data;

@Data
public class MenuCreateRequest {

    private String menuName;

    private String menuKey;

    private String component;

    private Long parentId;

    private String target;

    private Integer weight;

    private Integer menuType;

    private Integer visible;

    private String path;

    private String redirect;

}
