package io.sutsaehpeh.aqbp.user.request.sysuser;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class UserPageRequest implements Serializable {

    private String username;

    private String email;
    
    private List<Date> date;

    private Integer pageSize;

    private Integer pageNumber;

    private List<String> sortBy;

    private String direction;
}
