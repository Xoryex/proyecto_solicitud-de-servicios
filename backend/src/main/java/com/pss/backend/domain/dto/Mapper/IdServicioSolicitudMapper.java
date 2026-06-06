package com.pss.backend.domain.dto.mapper;

import org.mapstruct.Mapper;

import com.pss.backend.domain.dto.serviciosolicitud.IdServicioSolicitudDto;
import com.pss.backend.domain.entity.IdServicioSolicitud;

@Mapper(componentModel = "spring")
public interface IdServicioSolicitudMapper {

    IdServicioSolicitudDto toDto(IdServicioSolicitud entity);
    
    IdServicioSolicitud toEntity(IdServicioSolicitudDto dto);
}
