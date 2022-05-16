package io.sutsaehpeh.aqbp.auth.service.impl;

import cn.hutool.core.bean.BeanUtil;
import io.sutsaehpeh.aqbp.auth.model.AuthUser;
import io.sutsaehpeh.aqbp.auth.service.SysUserDetailService;
import io.sutsaehpeh.aqbp.common.exception.BusinessException;
import io.sutsaehpeh.aqbp.common.model.LoginUser;
import io.sutsaehpeh.aqbp.common.response.ApiResult;
import io.sutsaehpeh.aqbp.common.status.StatusCode;
import io.sutsaehpeh.aqbp.user.api.SysUserRpcApi;
import io.sutsaehpeh.aqbp.user.dto.SysUserDTO;
import io.sutsaehpeh.aqbp.user.request.UserLoadByFuzzyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SysUserDetailServiceImpl implements SysUserDetailService {

    @Autowired
    private SysUserRpcApi sysUserRpcApi;

    @Override
    public UserDetails loadUserByUsername(String queryString) throws UsernameNotFoundException {
        UserLoadByFuzzyRequest request = new UserLoadByFuzzyRequest();
        request.setQueryString(queryString);
        ApiResult<SysUserDTO> apiResult = sysUserRpcApi.findByUsernameOrEmail(request);
        if (!apiResult.isSuccess()) {
            throw new BusinessException(StatusCode.USER_NOT_EXISTS);
        }
        SysUserDTO dto = apiResult.getData();
        LoginUser user = BeanUtil.copyProperties(dto, LoginUser.class);
        return new AuthUser(user);
    }
}
