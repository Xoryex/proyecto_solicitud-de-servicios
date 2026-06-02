package com.pss.backend.domain.dto.Mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.pss.backend.domain.dto.permisoDto.create;
import com.pss.backend.domain.dto.permisoDto.response;
import com.pss.backend.domain.dto.permisoDto.update;
import com.pss.backend.domain.entity.permisos;

@Mapper(componentModel = "spring")
public interface PermisoMapper {

    response toDTO(permisos permiso);

    @Mapping(target = "rol", ignore = true)
    permisos toEntity(create permisoDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "rol", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(update permisoDto, @MappingTarget permisos permiso);
}