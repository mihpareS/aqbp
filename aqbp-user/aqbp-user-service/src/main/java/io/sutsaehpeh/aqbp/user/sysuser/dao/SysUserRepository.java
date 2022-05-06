package io.sutsaehpeh.aqbp.user.sysuser.dao;

import io.sutsaehpeh.aqbp.user.sysuser.entity.SysUser;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface SysUserRepository extends CrudRepository<SysUser, Long>, QuerydslPredicateExecutor<SysUser>, SysUserHierRepository {
}
