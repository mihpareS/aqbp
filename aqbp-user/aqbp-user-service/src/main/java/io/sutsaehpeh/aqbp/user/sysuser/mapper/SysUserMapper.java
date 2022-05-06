package io.sutsaehpeh.aqbp.user.sysuser.mapper;

import io.sutsaehpeh.aqbp.user.dto.SysUserDTO;
import io.sutsaehpeh.aqbp.user.sysuser.entity.SysUser;
import io.sutsaehpeh.aqbp.user.vo.SysUserVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SysUserMapper {

    SysUserDTO sysUserEntity2Dto(SysUser user);

    List<SysUserDTO> userEntities2Dto(List<SysUser> users);

    SysUserVO sysUserEntity2Vo(SysUser user);

    List<SysUserVO> userEntities2Vo(List<SysUser> users);

    SysUser sysUserDto2entity(SysUserDTO userDTO);

    List<SysUser> userDtoList2entities(List<SysUserDTO> dtoList);
}
