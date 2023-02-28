package io.sutsaehpeh.aqbp.web.sysuser.service;

import io.sutsaehpeh.aqbp.common.page.Page;
import io.sutsaehpeh.aqbp.common.response.ApiResult;
import io.sutsaehpeh.aqbp.user.request.sysuser.UserPageRequest;
import io.sutsaehpeh.aqbp.user.request.sysuser.UserRegisterRequest;
import io.sutsaehpeh.aqbp.user.vo.SysUserVO;

public interface SysUserService {

    ApiResult<SysUserVO> register(UserRegisterRequest request);

    ApiResult<SysUserVO> findById(Long id);

    ApiResult<Page<SysUserVO>> querySysUserPage(UserPageRequest request);



}
