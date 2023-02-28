package io.sutsaehpeh.aqbp.user.menu.mapper;

import io.sutsaehpeh.aqbp.user.dto.MenuDTO;
import io.sutsaehpeh.aqbp.user.menu.entity.Menu;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MenuMapper {

    Menu dto2Entity(MenuDTO menuDTO);

    MenuDTO entity2Dto(Menu menu);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateMenuFromMenuDTO(MenuDTO menuDTO, @MappingTarget Menu menu);
}
