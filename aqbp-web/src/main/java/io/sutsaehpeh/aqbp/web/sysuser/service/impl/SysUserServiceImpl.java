package io.sutsaehpeh.aqbp.web.sysuser.service.impl;

import cn.hutool.core.bean.BeanUtil;
import io.sutsaehpeh.aqbp.common.page.Page;
import io.sutsaehpeh.aqbp.common.response.ApiResult;
import io.sutsaehpeh.aqbp.web.sysuser.service.SysUserService;
import io.sutsaehpeh.aqbp.user.api.SysUserRpcApi;
import io.sutsaehpeh.aqbp.user.dto.SysUserDTO;
import io.sutsaehpeh.aqbp.user.request.UserListRequest;
import io.sutsaehpeh.aqbp.user.request.UserPageRequest;
import io.sutsaehpeh.aqbp.user.request.UserRegisterRequest;
import io.sutsaehpeh.aqbp.user.vo.SysUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserRpcApi sysUserRpcApi;

    @Override
    public ApiResult<SysUserVO> register(UserRegisterRequest request) {
        ApiResult<SysUserDTO> rpcResult = sysUserRpcApi.createUser(request);
        SysUserVO vo = new SysUserVO();
        if (rpcResult.isSuccess()) {
            BeanUtil.copyProperties(rpcResult.getData(), vo);
        }
        ApiResult<SysUserVO> result = new ApiResult<>();
        result.setCode(rpcResult.getCode());
        result.setMsg(rpcResult.getMsg());
        result.setData(vo);
        return result;
    }

    @Override
    public ApiResult<SysUserVO> findById(Long id) {
        ApiResult<SysUserDTO> rpcResult = sysUserRpcApi.findById(id);
        SysUserVO vo = new SysUserVO();
        if (rpcResult.isSuccess()) {
            BeanUtil.copyProperties(rpcResult.getData(), vo);
        }
        ApiResult<SysUserVO> result = new ApiResult<>();
        result.setCode(rpcResult.getCode());
        result.setMsg(rpcResult.getMsg());
        result.setData(vo);
        return result;
    }

    @Override
    public ApiResult<List<SysUserVO>> querySysUserList(UserListRequest request) {
        ApiResult<List<SysUserDTO>> rpcResult = sysUserRpcApi.queryUserList(request);
        List<SysUserVO> userList = null;
        if (rpcResult.isSuccess()) {
            userList = BeanUtil.copyToList(rpcResult.getData(), SysUserVO.class);
        } else {
            userList = new ArrayList<>();
        }
        ApiResult<List<SysUserVO>> result = new ApiResult<>();
        result.setCode(rpcResult.getCode());
        result.setMsg(rpcResult.getMsg());
        result.setData(userList);
        return result;
    }

    @Override
    public ApiResult<Page<SysUserVO>> querySysUserPage(UserPageRequest request) {
        ApiResult<Page<SysUserDTO>> rpcResult = sysUserRpcApi.queryUserPage(request);
        Page<SysUserDTO> rpcPage = rpcResult.getData();
        Page<SysUserVO> page = new Page<>();
        BeanUtil.copyProperties(rpcPage, page, "element");
        if (rpcResult.isSuccess()) {
            List<SysUserVO> ele = BeanUtil.copyToList(rpcPage.getElement(), SysUserVO.class);
            page.setElement(ele);
        }
        ApiResult<Page<SysUserVO>> result = new ApiResult<>();
        result.setCode(rpcResult.getCode());
        result.setMsg(rpcResult.getMsg());
        result.setData(page);
        return result;
    }
}
