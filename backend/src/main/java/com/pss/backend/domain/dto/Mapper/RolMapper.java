package com.pss.backend.domain.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.pss.backend.domain.dto.rol.RolCreateDto;
import com.pss.backend.domain.dto.rol.RolResponseDto;
import com.pss.backend.domain.dto.rol.RolUpdateDto;
import com.pss.backend.domain.entity.Roles;

@Mapper(componentModel = "spring")
public interface RolMapper {

    RolResponseDto toDTO(Roles rol);

    @Mapping(target = "usuarios", ignore = true)
    @Mapping(target = "idRol", ignore = true)
    Roles toEntity(RolCreateDto rolCreateDto);

    @Mapping(target = "usuarios", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(RolUpdateDto rolUpdateDto, @MappingTarget Roles rol);

}
