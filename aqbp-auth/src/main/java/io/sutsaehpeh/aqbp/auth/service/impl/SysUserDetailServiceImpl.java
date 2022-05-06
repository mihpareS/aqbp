package io.sutsaehpeh.aqbp.auth.service.impl;

import io.sutsaehpeh.aqbp.auth.service.SysUserDetailService;
import io.sutsaehpeh.aqbp.common.response.ApiResult;
import io.sutsaehpeh.aqbp.common.status.StatusCode;
import io.sutsaehpeh.aqbp.user.api.SysUserRpcApi;
import io.sutsaehpeh.aqbp.user.dto.SysUserDTO;
import io.sutsaehpeh.aqbp.user.request.UserPreciseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SysUserDetailServiceImpl implements SysUserDetailService {


    @Autowired
    private SysUserRpcApi sysUserRpcApi;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPreciseRequest request = new UserPreciseRequest();
        request.setUsername(username);
        ApiResult<SysUserDTO> rpcResult = sysUserRpcApi.findUserPrecisely(request);
        if (!rpcResult.isSuccess()) {
            throw new UsernameNotFoundException(StatusCode.USER_NOT_EXISTS.getMsg());
        }
        
        return null;
    }

}
