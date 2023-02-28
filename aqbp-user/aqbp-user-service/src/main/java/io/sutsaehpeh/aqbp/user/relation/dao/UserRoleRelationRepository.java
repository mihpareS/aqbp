package io.sutsaehpeh.aqbp.user.relation.dao;

import io.sutsaehpeh.aqbp.user.relation.entity.UserRoleRelation;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRelationRepository extends CrudRepository<UserRoleRelation, Long> {
}