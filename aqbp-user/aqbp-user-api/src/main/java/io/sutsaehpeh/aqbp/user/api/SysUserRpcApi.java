package io.sutsaehpeh.aqbp.user.api;

import io.sutsaehpeh.aqbp.common.page.Page;
import io.sutsaehpeh.aqbp.common.response.ApiResult;
import io.sutsaehpeh.aqbp.user.dto.SysUserDTO;
import io.sutsaehpeh.aqbp.user.request.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "aqbp-user")
public interface SysUserRpcApi {

    @PostMapping("/sysuser/create")
    ApiResult<SysUserDTO> createUser(@RequestBody UserRegisterRequest request);

    @GetMapping("/sysuser/{id}")
    ApiResult<SysUserDTO> findById(@PathVariable("id") Long id);

    @PostMapping("/sysuser/find-by-username")
    ApiResult<SysUserDTO> findByUsernameOrEmail(@RequestBody UserLoadByFuzzyRequest request);

    @PostMapping("/sysuser")
    ApiResult<List<SysUserDTO>> queryUserList(@RequestBody UserListRequest request);

    @GetMapping("/sysuser")
    ApiResult<Page<SysUserDTO>> queryUserPage(@SpringQueryMap UserPageRequest request);
}
