package io.sutsaehpeh.aqbp.web.web.controller;

import io.sutsaehpeh.aqbp.common.page.Page;
import io.sutsaehpeh.aqbp.common.response.ApiResult;
import io.sutsaehpeh.aqbp.user.request.sysuser.UserPageRequest;
import io.sutsaehpeh.aqbp.user.request.sysuser.UserRegisterRequest;
import io.sutsaehpeh.aqbp.user.vo.SysUserVO;
import io.sutsaehpeh.aqbp.web.sysuser.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sysusers")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping
    public ApiResult<SysUserVO> register(@RequestBody UserRegisterRequest request) {
        return sysUserService.register(request);
    }

    @GetMapping("/{id}")
    public ApiResult<SysUserVO> findById(@PathVariable("id") Long id) {
        return sysUserService.findById(id);
    }

    @GetMapping
    public ApiResult<Page<SysUserVO>> querySysUserPage(UserPageRequest request) {
        return sysUserService.querySysUserPage(request);
    }
}
