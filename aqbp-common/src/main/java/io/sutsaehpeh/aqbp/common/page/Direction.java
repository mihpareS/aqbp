package io.sutsaehpeh.aqbp.common.page;

import lombok.Getter;

@Getter
public enum Direction {

    ASC("asc", "order by asc"),
    DESC("desc", "order by desc"),
    ;
    private final String direction;

    private final String desc;

    Direction(String direction, String desc) {
        this.direction = direction;
        this.desc = desc;
    }

    public String getDirection() {
        return direction;
    }

    public String getDesc() {
        return desc;
    }
}
