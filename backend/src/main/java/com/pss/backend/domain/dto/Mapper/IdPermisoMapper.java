package com.pss.backend.domain.dto.mapper;

import org.mapstruct.Mapper;

import com.pss.backend.domain.dto.permiso.IdPermisoDto;
import com.pss.backend.domain.entity.IdPermiso;

@Mapper(componentModel = "spring")
public interface IdPermisoMapper {

    IdPermisoDto toDTO(IdPermiso permisoId);
    
    IdPermiso toEntity(IdPermisoDto permisoIdDto);
}
