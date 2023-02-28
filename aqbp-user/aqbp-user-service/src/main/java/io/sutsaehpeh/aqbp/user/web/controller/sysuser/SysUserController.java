package io.sutsaehpeh.aqbp.user.web.controller.sysuser;

import io.sutsaehpeh.aqbp.common.page.Page;
import io.sutsaehpeh.aqbp.common.response.ApiResult;
import io.sutsaehpeh.aqbp.user.dto.SysUserDTO;
import io.sutsaehpeh.aqbp.user.request.sysuser.UserPageRequest;
import io.sutsaehpeh.aqbp.user.request.sysuser.UserRegisterRequest;
import io.sutsaehpeh.aqbp.user.sysuser.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sysusers")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping
    public ApiResult<SysUserDTO> createUser(@RequestBody UserRegisterRequest registerRequest) {
        return ApiResult.ok(sysUserService.createUser(registerRequest));
    }

    @GetMapping("/{id}")
    public ApiResult<SysUserDTO> findUserById(@PathVariable("id") Long id) {
        return ApiResult.ok(sysUserService.findUserById(id));
    }

    @GetMapping("/queryByLogin")
    public ApiResult<SysUserDTO> findUserByUsernameOrEmail(@RequestParam String query) {
        return ApiResult.ok(sysUserService.findUserByUsernameOrEmail(query));
    }

    @GetMapping
    public ApiResult<Page<SysUserDTO>> queryUserPage(UserPageRequest request) {
        return ApiResult.ok(sysUserService.queryUserPage(request));
    }
}
