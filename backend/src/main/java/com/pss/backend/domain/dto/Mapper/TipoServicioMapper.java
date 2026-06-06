package com.pss.backend.domain.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.pss.backend.domain.dto.tiposervicio.TipoServicioCreateDto;
import com.pss.backend.domain.dto.tiposervicio.TipoServicioDto;
import com.pss.backend.domain.entity.TipoServicio;

@Mapper(componentModel = "spring")
public interface TipoServicioMapper {

    @Mapping(target = "servicios", ignore = true)
    @Mapping(target = "idTipoServicio", ignore = true)
    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    TipoServicio toEntity(TipoServicioCreateDto dto);

    TipoServicioDto toDto(TipoServicio entity);

    @Mapping(target = "servicios", ignore = true)
    @Mapping(target = "idTipoServicio", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(TipoServicioDto dto, @MappingTarget TipoServicio entity);

}
