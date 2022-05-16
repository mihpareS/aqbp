package io.sutsaehpeh.aqbp.user.web.controller.sysuser;

import io.sutsaehpeh.aqbp.common.page.Page;
import io.sutsaehpeh.aqbp.common.response.ApiResult;
import io.sutsaehpeh.aqbp.user.dto.SysUserDTO;
import io.sutsaehpeh.aqbp.user.request.*;
import io.sutsaehpeh.aqbp.user.sysuser.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sysuser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/create")
    public ApiResult<SysUserDTO> createUser(@RequestBody UserRegisterRequest registerRequest) {
        return ApiResult.ok(sysUserService.createUser(registerRequest));
    }

    @GetMapping("/{id}")
    public ApiResult<SysUserDTO> findUserById(@PathVariable("id") Long id) {
        return ApiResult.ok(sysUserService.findUserById(id));
    }

    @PostMapping("/find-by-username")
    public ApiResult<SysUserDTO> findUserByUsernameOrEmail(@RequestBody UserLoadByFuzzyRequest request) {
        return ApiResult.ok(sysUserService.findUserByUsernameOrEmail(request));
    }

    @PostMapping("/precise")
    public ApiResult<SysUserDTO> findUserPrecisely(@RequestBody UserPreciseRequest request) {
        return ApiResult.ok(sysUserService.findUserPrecisely(request));
    }


    @PostMapping
    public ApiResult<List<SysUserDTO>> queryUserList(@RequestBody UserListRequest request) {
        return ApiResult.ok(sysUserService.queryUserList(request));
    }

    @GetMapping
    public ApiResult<Page<SysUserDTO>> queryUserPage(UserPageRequest request) {
        return ApiResult.ok(sysUserService.queryUserPage(request));
    }
}
