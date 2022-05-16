package io.sutsaehpeh.aqbp.web.web.controller;

import io.sutsaehpeh.aqbp.common.page.Page;
import io.sutsaehpeh.aqbp.common.response.ApiResult;
import io.sutsaehpeh.aqbp.web.sysuser.service.SysUserService;
import io.sutsaehpeh.aqbp.user.request.UserListRequest;
import io.sutsaehpeh.aqbp.user.request.UserPageRequest;
import io.sutsaehpeh.aqbp.user.request.UserRegisterRequest;
import io.sutsaehpeh.aqbp.user.vo.SysUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sysuser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/create")
    public ApiResult<SysUserVO> register(@RequestBody UserRegisterRequest request) {
        return sysUserService.register(request);
    }

    @GetMapping("/{id}")
    public ApiResult<SysUserVO> findById(@PathVariable("id") Long id) {
        return sysUserService.findById(id);
    }

    @PostMapping
    public ApiResult<List<SysUserVO>> querySysUserList(@RequestBody UserListRequest request) {
        return sysUserService.querySysUserList(request);
    }

    @GetMapping
    public ApiResult<Page<SysUserVO>> querySysUserPage(UserPageRequest request) {
        return sysUserService.querySysUserPage(request);
    }
}
