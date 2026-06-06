package com.pss.backend.domain.dto.solicitud;

import lombok.Builder;

@Builder
public record SolicitudCreateDto(
    Short estado,
    Integer idCliente
) {}
