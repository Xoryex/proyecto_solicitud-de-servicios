package com.pss.backend.domain.dto.mapper;

import org.mapstruct.Mapper;

import com.pss.backend.domain.dto.horario.IdHorarioDto;
import com.pss.backend.domain.entity.IdHorario;

@Mapper(componentModel = "spring")
public interface IdHorarioMapper {

    IdHorarioDto toDto(IdHorario entity);
    
    IdHorario toEntity(IdHorarioDto dto);
}
