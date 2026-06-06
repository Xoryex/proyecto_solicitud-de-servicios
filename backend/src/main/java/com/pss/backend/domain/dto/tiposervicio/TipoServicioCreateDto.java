package com.pss.backend.domain.dto.tiposervicio;

import lombok.Builder;

@Builder
public record TipoServicioCreateDto(
    String tipoServicio,
    String descripcion,
    Short estado
) {}
