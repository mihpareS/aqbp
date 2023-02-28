package io.sutsaehpeh.aqbp.user.role.mapper;

import io.sutsaehpeh.aqbp.user.dto.RoleDTO;
import io.sutsaehpeh.aqbp.user.role.entity.Role;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RoleMapper {
    Role dto2Entity(RoleDTO roleDTO);

    RoleDTO entity2Dto(Role role);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateRoleFromRoleDTO(RoleDTO roleDTO, @MappingTarget Role role);
}
