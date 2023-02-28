package io.sutsaehpeh.aqbp.user.sysuser.service;

import io.sutsaehpeh.aqbp.common.page.Page;
import io.sutsaehpeh.aqbp.user.dto.SysUserDTO;
import io.sutsaehpeh.aqbp.user.request.sysuser.UserPageRequest;
import io.sutsaehpeh.aqbp.user.request.sysuser.UserRegisterRequest;

public interface SysUserService {

    SysUserDTO createUser(UserRegisterRequest request);

    SysUserDTO findUserById(Long id);

    SysUserDTO findUserByUsernameOrEmail(String queryString);

    Page<SysUserDTO> queryUserPage(UserPageRequest request);
}
