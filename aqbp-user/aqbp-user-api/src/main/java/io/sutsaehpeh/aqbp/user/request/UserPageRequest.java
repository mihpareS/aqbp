package io.sutsaehpeh.aqbp.user.request;

import io.sutsaehpeh.aqbp.common.page.Sort;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class UserPageRequest implements Serializable {

    private String username;

    private String email;

    private Date registerStartDate;

    private Date registerEndDate;

    private Integer pageSize;

    private Integer pageNumber;

    private List<String> sortBy;

    private String direction;
}
