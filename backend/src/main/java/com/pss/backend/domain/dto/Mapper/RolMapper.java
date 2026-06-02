package com.pss.backend.domain.dto.Mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.pss.backend.domain.dto.rolDto;
import com.pss.backend.domain.entity.roles;

@Mapper(componentModel = "spring")
public interface RolMapper {

    rolDto.response toDTO(roles rol);

    @Mapping(target = "usuarios", ignore = true)
    @Mapping(target = "id", ignore = true)
    roles toEntity(rolDto.create rolCreateDto);

    @Mapping(target = "usuarios", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(rolDto.update rolUpdateDto, @MappingTarget roles rol);

}
