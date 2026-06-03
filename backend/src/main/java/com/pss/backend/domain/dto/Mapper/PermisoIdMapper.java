package com.pss.backend.domain.dto.mapper;

import org.mapstruct.Mapper;

import com.pss.backend.domain.dto.permiso.PermisoIdDto;
import com.pss.backend.domain.entity.PermisosId;

@Mapper(componentModel = "spring")
public interface PermisoIdMapper {

    PermisoIdDto toDTO(PermisosId permisoId);
    
    PermisosId toEntity(PermisoIdDto permisoIdDto);
}
