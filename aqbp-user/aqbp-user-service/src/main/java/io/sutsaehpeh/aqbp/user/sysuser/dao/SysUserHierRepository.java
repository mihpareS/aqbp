package io.sutsaehpeh.aqbp.user.sysuser.dao;

import com.blazebit.persistence.PagedList;
import io.sutsaehpeh.aqbp.user.sysuser.dao.query.UserQueryCondition;
import io.sutsaehpeh.aqbp.user.sysuser.entity.SysUser;

import java.util.List;

public interface SysUserHierRepository {

    SysUser findUserByUsernameOrEmail(UserQueryCondition query);

    SysUser findUserPrecisely(UserQueryCondition query);

    List<SysUser> queryUserList(UserQueryCondition query);

    PagedList<SysUser> queryUserPage(UserQueryCondition query);
}
