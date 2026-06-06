package com.pss.backend.domain.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.pss.backend.domain.dto.rol.RolCreateDto;
import com.pss.backend.domain.dto.rol.RolDto;
import com.pss.backend.domain.entity.Rol;

@Mapper(componentModel = "spring")
public interface RolMapper {

    RolDto toDTO(Rol rol);

    @Mapping(target = "usuarios", ignore = true)
    @Mapping(target = "idRol", ignore = true)
    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Rol toEntity(RolCreateDto rolCreateDto);

    @Mapping(target = "usuarios", ignore = true)
    @Mapping(target = "idRol", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(RolDto rolDto, @MappingTarget Rol rol);

}
