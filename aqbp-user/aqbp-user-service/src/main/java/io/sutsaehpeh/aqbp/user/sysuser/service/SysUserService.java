package io.sutsaehpeh.aqbp.user.sysuser.service;

import io.sutsaehpeh.aqbp.common.page.Page;
import io.sutsaehpeh.aqbp.user.dto.SysUserDTO;
import io.sutsaehpeh.aqbp.user.request.*;

import java.util.List;

public interface SysUserService {

    SysUserDTO createUser(UserRegisterRequest request);

    SysUserDTO findUserById(Long id);

    SysUserDTO findUserByUsernameOrEmail(UserLoadByFuzzyRequest request);

    SysUserDTO findUserPrecisely(UserPreciseRequest request);

    List<SysUserDTO> queryUserList(UserListRequest request);

    Page<SysUserDTO> queryUserPage(UserPageRequest request);
}
