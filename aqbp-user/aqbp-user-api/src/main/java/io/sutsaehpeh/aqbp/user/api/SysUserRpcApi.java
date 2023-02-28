package io.sutsaehpeh.aqbp.user.api;

import io.sutsaehpeh.aqbp.common.page.Page;
import io.sutsaehpeh.aqbp.common.response.ApiResult;
import io.sutsaehpeh.aqbp.user.dto.SysUserDTO;
import io.sutsaehpeh.aqbp.user.request.sysuser.UserPageRequest;
import io.sutsaehpeh.aqbp.user.request.sysuser.UserRegisterRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "aqbp-user")
public interface SysUserRpcApi {

    @PostMapping("/sysusers/")
    ApiResult<SysUserDTO> createUser(@RequestBody UserRegisterRequest request);

    @GetMapping("/sysusers/{id}")
    ApiResult<SysUserDTO> findById(@PathVariable("id") Long id);

    @GetMapping("/sysusers/queryByLogin")
    ApiResult<SysUserDTO> findByUsernameOrEmail(@RequestParam("query") String query);

    @GetMapping("/sysusers")
    ApiResult<Page<SysUserDTO>> queryUserPage(@SpringQueryMap UserPageRequest request);
}
