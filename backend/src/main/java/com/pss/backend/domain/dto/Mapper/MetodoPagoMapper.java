package com.pss.backend.domain.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import com.pss.backend.domain.dto.metodopago.MetodoPagoCreateDto;
import com.pss.backend.domain.dto.metodopago.MetodoPagoDto;
import com.pss.backend.domain.entity.MetodoPago;


@Mapper(componentModel = "spring")
public interface MetodoPagoMapper {

    @Mapping(target = "idMetodoPago", ignore = true)
    @Mapping(target = "serviciosMetodosPago", ignore = true)
    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    MetodoPago toEntity(MetodoPagoCreateDto dto);


    MetodoPagoDto toDto(MetodoPago entity);

    @Mapping(target = "serviciosMetodosPago", ignore = true)
    @Mapping(target = "idMetodoPago", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(MetodoPagoDto dto, @MappingTarget MetodoPago entity);
}
