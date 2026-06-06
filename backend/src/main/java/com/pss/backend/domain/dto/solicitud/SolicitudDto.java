package com.pss.backend.domain.dto.solicitud;

import lombok.Builder;

@Builder
public record SolicitudDto(
    Integer idSolicitud,
    Short estado,
    Integer idCliente
) {}
