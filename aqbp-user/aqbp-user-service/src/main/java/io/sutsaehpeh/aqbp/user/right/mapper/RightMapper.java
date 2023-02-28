package io.sutsaehpeh.aqbp.user.right.mapper;

import io.sutsaehpeh.aqbp.user.dto.RightDTO;
import io.sutsaehpeh.aqbp.user.right.entity.Right;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RightMapper {
    Right dto2Entity(RightDTO rightDTO);

    RightDTO entity2Dto(Right right);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateRightFromRightDTO(RightDTO rightDTO, @MappingTarget Right right);
}
