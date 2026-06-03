package com.pss.backend.domain.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.pss.backend.domain.dto.permiso.PermisoCreateDto;
import com.pss.backend.domain.dto.permiso.PermisoResponseDto;
import com.pss.backend.domain.dto.permiso.PermisoUpdateDto;
import com.pss.backend.domain.entity.Permisos;

@Mapper(componentModel = "spring")
public interface PermisoMapper {

    PermisoResponseDto toDTO(Permisos permiso);

    @Mapping(target = "rol", ignore = true)
    Permisos toEntity(PermisoCreateDto permisoDto);

    @Mapping(target = "idPermiso", ignore = true)
    @Mapping(target = "rol", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(PermisoUpdateDto permisoDto, @MappingTarget Permisos permiso);
}