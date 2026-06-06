package com.pss.backend.domain.dto.horario;

import lombok.Builder;

@Builder
public record IdHorarioDto(
    String dia,
    Integer idProveedor
) {}
