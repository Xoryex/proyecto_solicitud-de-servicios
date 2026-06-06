package com.pss.backend.domain.dto.tiposervicio;

import lombok.Builder;

@Builder
public record TipoServicioDto(
    Integer idTipoServicio,
    String tipoServicio,
    String descripcion,
    Short estado
) {}
