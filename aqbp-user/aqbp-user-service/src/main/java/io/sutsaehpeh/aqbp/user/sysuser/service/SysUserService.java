package io.sutsaehpeh.aqbp.user.sysuser.service;

import io.sutsaehpeh.aqbp.common.page.Page;
import io.sutsaehpeh.aqbp.user.dto.SysUserDTO;
import io.sutsaehpeh.aqbp.user.request.UserListRequest;
import io.sutsaehpeh.aqbp.user.request.UserPageRequest;
import io.sutsaehpeh.aqbp.user.request.UserPreciseRequest;
import io.sutsaehpeh.aqbp.user.request.UserRegisterRequest;

import java.util.List;

public interface SysUserService {

    SysUserDTO createUser(UserRegisterRequest request);

    SysUserDTO findUserById(Long id);

    SysUserDTO findUserPrecisely(UserPreciseRequest request);

    List<SysUserDTO> queryUserList(UserListRequest request);

    Page<SysUserDTO> queryUserPage(UserPageRequest request);
}
