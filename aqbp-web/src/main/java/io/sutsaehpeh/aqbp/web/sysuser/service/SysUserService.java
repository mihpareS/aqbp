package io.sutsaehpeh.aqbp.web.sysuser.service;

import io.sutsaehpeh.aqbp.common.page.Page;
import io.sutsaehpeh.aqbp.common.response.ApiResult;
import io.sutsaehpeh.aqbp.user.request.UserListRequest;
import io.sutsaehpeh.aqbp.user.request.UserPageRequest;
import io.sutsaehpeh.aqbp.user.request.UserRegisterRequest;
import io.sutsaehpeh.aqbp.user.vo.SysUserVO;

import java.util.List;

public interface SysUserService {

    ApiResult<SysUserVO> register(UserRegisterRequest request);

    ApiResult<SysUserVO> findById(Long id);

    ApiResult<List<SysUserVO>> querySysUserList(UserListRequest request);

    ApiResult<Page<SysUserVO>> querySysUserPage(UserPageRequest request);



}
