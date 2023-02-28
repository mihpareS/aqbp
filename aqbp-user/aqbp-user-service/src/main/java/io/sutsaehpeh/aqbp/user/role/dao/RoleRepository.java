package io.sutsaehpeh.aqbp.user.role.dao;

import io.sutsaehpeh.aqbp.user.role.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}