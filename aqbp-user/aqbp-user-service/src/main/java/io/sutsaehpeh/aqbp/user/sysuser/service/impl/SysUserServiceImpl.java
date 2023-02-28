package io.sutsaehpeh.aqbp.user.sysuser.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.blazebit.persistence.PagedList;
import io.sutsaehpeh.aqbp.common.exception.BusinessException;
import io.sutsaehpeh.aqbp.common.page.Page;
import io.sutsaehpeh.aqbp.common.status.StatusCode;
import io.sutsaehpeh.aqbp.user.dto.SysUserDTO;
import io.sutsaehpeh.aqbp.user.request.sysuser.UserPageRequest;
import io.sutsaehpeh.aqbp.user.request.sysuser.UserRegisterRequest;
import io.sutsaehpeh.aqbp.user.sysuser.dao.SysUserRepository;
import io.sutsaehpeh.aqbp.user.sysuser.dao.query.UserQueryCondition;
import io.sutsaehpeh.aqbp.user.sysuser.entity.SysUser;
import io.sutsaehpeh.aqbp.user.sysuser.mapper.SysUserMapper;
import io.sutsaehpeh.aqbp.user.sysuser.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper mapper;

    @Autowired
    private SysUserRepository sysUserRepository;


    @Override
    public SysUserDTO createUser(UserRegisterRequest request) {
        request.validate();
        SysUser user = new SysUser();
        user.setUsername(request.getUsername());
        String salt = BCrypt.gensalt();
        String originalPassword = request.getPassword();
        String hashedPassword = BCrypt.hashpw(originalPassword, salt);
        user.setPassword(hashedPassword);
        user.setSalt(salt);
        user.setEmail(request.getEmail());
        sysUserRepository.save(user);
        return mapper.sysUserEntity2Dto(user);
    }

    @Override
    public SysUserDTO findUserById(Long id) {
        SysUser user = sysUserRepository.findById(id).orElseThrow(() -> new BusinessException(StatusCode.USER_NOT_EXISTS));
        return mapper.sysUserEntity2Dto(user);
    }

    @Override
    public SysUserDTO findUserByUsernameOrEmail(String queryString) {
        UserQueryCondition condition = new UserQueryCondition();
        condition.setQueryString(queryString);
        SysUser user = sysUserRepository.findUserByUsernameOrEmail(condition);
        return mapper.sysUserEntity2Dto(user);
    }

    @Override
    public Page<SysUserDTO> queryUserPage(UserPageRequest request) {
        UserQueryCondition condition = BeanUtil.copyProperties(request, UserQueryCondition.class);
        PagedList<SysUser> dbList = sysUserRepository.queryUserPage(condition);
        Page<SysUserDTO> page = new Page<>();
        page.setTotalPages(dbList.getTotalPages());
        page.setPageNumber(dbList.getPage());
        page.setPageSize(request.getPageSize());
        List<SysUserDTO> dtoList = mapper.userEntities2Dto(dbList);
        page.setElement(dtoList);
        return page;
    }
}
