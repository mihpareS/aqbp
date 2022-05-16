package io.sutsaehpeh.aqbp.user.request;

import lombok.Data;

@Data
public class UserLoadByFuzzyRequest {

    private String queryString;
}
