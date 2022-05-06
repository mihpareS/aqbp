package io.sutsaehpeh.aqbp.common.page;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {

    private String property;

    private Direction direction;

}
