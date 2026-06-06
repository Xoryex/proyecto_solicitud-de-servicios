package com.pss.backend.domain.dto.mapper;

import org.mapstruct.Mapper;

import com.pss.backend.domain.dto.serviciometodopago.IdServicioMetodoPagoDto;
import com.pss.backend.domain.entity.IdServicioMetodoPago;

@Mapper(componentModel = "spring")
public interface IdServicioMetodoPagoMapper {

    IdServicioMetodoPagoDto toDto(IdServicioMetodoPago entity);
    
    IdServicioMetodoPago toEntity(IdServicioMetodoPagoDto dto);
}
