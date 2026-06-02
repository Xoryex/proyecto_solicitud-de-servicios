package com.pss.backend.domain.dto.Mapper;

import org.mapstruct.Mapper;

import com.pss.backend.domain.dto.permisoDto;
import com.pss.backend.domain.entity.permisosId;

@Mapper(componentModel = "spring")
public interface PermisoIdMapper {

    permisoDto.id toDTO(permisosId permisoId);
    
    permisosId toEntity(permisoDto.id permisoIdDto);
}
