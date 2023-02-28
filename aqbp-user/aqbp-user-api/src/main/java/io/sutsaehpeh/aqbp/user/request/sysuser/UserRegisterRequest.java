package io.sutsaehpeh.aqbp.user.request.sysuser;

import cn.hutool.core.util.StrUtil;
import io.sutsaehpeh.aqbp.common.exception.BusinessException;
import io.sutsaehpeh.aqbp.common.status.StatusCode;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserRegisterRequest implements Serializable {

    private String username;

    private String password;

    private String email;


    public void validate() {
        if (StrUtil.isBlankIfStr(username)) {
            throw new BusinessException(StatusCode.REGISTER_NAME_ILLEGAL);
        }

        if (StrUtil.isBlankIfStr(password)) {
            throw new BusinessException(StatusCode.REGISTER_PASSWORD_ILLEGAL);
        }

        if (StrUtil.isBlankIfStr(email)) {
            throw new BusinessException(StatusCode.REGISTER_EMAIL_ILLEGAL);
        }
    }
}
