package io.sutsaehpeh.aqbp.user.sysuser.dao.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import io.sutsaehpeh.aqbp.common.util.QuerydslOrderUtil;
import io.sutsaehpeh.aqbp.user.constant.SysUserOrderRestriction;
import io.sutsaehpeh.aqbp.user.sysuser.dao.SysUserHierRepository;
import io.sutsaehpeh.aqbp.user.sysuser.dao.query.UserQueryCondition;
import io.sutsaehpeh.aqbp.user.sysuser.entity.QSysUser;
import io.sutsaehpeh.aqbp.user.sysuser.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SysUserHierRepositoryImpl implements SysUserHierRepository {


    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CriteriaBuilderFactory criteriaBuilderFactory;


    @Override
    public SysUser findUserByUsernameOrEmail(UserQueryCondition condition) {
        String queryString = condition.getQueryString();
        Predicate usernamePredicate = QSysUser.sysUser.username.eq(queryString);
        Predicate emailPredicate = QSysUser.sysUser.email.eq(queryString);
        BlazeJPAQuery<SysUser> query = new BlazeJPAQuery<>(entityManager, criteriaBuilderFactory)
                .select(QSysUser.sysUser)
                .from(QSysUser.sysUser);
        return query.where(ExpressionUtils.or(usernamePredicate, emailPredicate))
                .fetchOne();
    }

    @Override
    public SysUser findUserPrecisely(UserQueryCondition condition) {
        List<Predicate> predicates = new ArrayList<>();
        if (StrUtil.isNotBlank(condition.getUsername())) {
            predicates.add(QSysUser.sysUser.username.eq(condition.getUsername()));
        }
        if (StrUtil.isNotBlank(condition.getEmail())) {
            predicates.add(QSysUser.sysUser.email.eq(condition.getEmail()));
        }
        if (CollectionUtil.isEmpty(predicates)) {
            return new SysUser();
        }
        BlazeJPAQuery<SysUser> query = new BlazeJPAQuery<>(entityManager, criteriaBuilderFactory)
                .select(QSysUser.sysUser)
                .from(QSysUser.sysUser);
        return query.where(predicates.toArray(new Predicate[0]))
                .fetchOne();
    }


    @Override
    public List<SysUser> queryUserList(UserQueryCondition condition) {
        Long userId = condition.getUserId();
        String username = condition.getUsername();
        String email = condition.getEmail();
        Date startDate = condition.getRegisterStartDate();
        Date endDate = condition.getRegisterEndDate();
        BlazeJPAQuery<SysUser> query = new BlazeJPAQuery<>(entityManager, criteriaBuilderFactory)
                .select(QSysUser.sysUser).from(QSysUser.sysUser);
        List<Predicate> predicates = new ArrayList<>();
        if (ObjectUtil.isNotNull(userId)) {
            predicates.add(QSysUser.sysUser.userId.eq(userId));
        }
        if (StrUtil.isNotBlank(username)) {
            predicates.add(QSysUser.sysUser.username.startsWith(username));
        }
        if (StrUtil.isNotBlank(email)) {
            predicates.add(QSysUser.sysUser.email.startsWith(email));
        }
        if (ObjectUtil.isNotNull(startDate) && ObjectUtil.isNotNull(endDate)) {
            predicates.add(QSysUser.sysUser.registerDate.between(startDate, endDate));
        }
        return query.where(
                        predicates.toArray(new Predicate[0])
                )
                .fetch();
    }

    @Override
    public PagedList<SysUser> queryUserPage(UserQueryCondition condition) {
        Long userId = condition.getUserId();
        String username = condition.getUsername();
        String email = condition.getEmail();
        Date startDate = condition.getRegisterStartDate();
        Date endDate = condition.getRegisterEndDate();
        Integer pageNumber = condition.getPageNumber();
        Integer pageSize = condition.getPageSize();
        List<String> sortBy = condition.getSortBy();
        String direction = condition.getDirection();
        BlazeJPAQuery<SysUser> query = new BlazeJPAQuery<>(entityManager, criteriaBuilderFactory)
                .select(QSysUser.sysUser)
                .from(QSysUser.sysUser);
        if (ObjectUtil.isNull(pageNumber) || pageNumber <= 0) {
            pageNumber = 1;
        }
        if (ObjectUtil.isNull(pageSize)) {
            pageSize = 10;
        }
        List<Predicate> predicates = new ArrayList<>();
        if (ObjectUtil.isNotNull(userId)) {
            predicates.add(QSysUser.sysUser.userId.eq(userId));
        }
        if (StrUtil.isNotBlank(username)) {
            predicates.add(QSysUser.sysUser.username.startsWith(username));
        }
        if (StrUtil.isNotBlank(email)) {
            predicates.add(QSysUser.sysUser.email.startsWith(email));
        }
        if (ObjectUtil.isNotNull(startDate) && ObjectUtil.isNotNull(endDate)) {
            predicates.add(QSysUser.sysUser.registerDate.between(startDate, endDate));
        }
        List<OrderSpecifier<?>> specifiers = new ArrayList<>();
        if (ObjectUtil.isNull(sortBy) || CollectionUtil.isEmpty(sortBy)) {
            specifiers.add(new OrderSpecifier<>(Order.DESC, QSysUser.sysUser.userId));
        } else {
            sortBy.add(SysUserOrderRestriction.USER_ID);
            sortBy = sortBy.stream().distinct().filter(SysUserOrderRestriction.Restrictions::contains)
                    .collect(Collectors.toList());
            specifiers.addAll(QuerydslOrderUtil.getSortColumnList(QSysUser.sysUser, direction, sortBy));
        }
        return query.where(predicates.toArray(new Predicate[0]))
                .orderBy(specifiers.toArray(new OrderSpecifier[0]))
                .fetchPage((pageNumber - 1) * pageSize, pageSize);
    }
}
