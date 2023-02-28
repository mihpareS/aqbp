package io.sutsaehpeh.aqbp.user.menu.dao;

import io.sutsaehpeh.aqbp.user.menu.entity.Menu;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menu, Long>, QuerydslPredicateExecutor<Menu> {
}