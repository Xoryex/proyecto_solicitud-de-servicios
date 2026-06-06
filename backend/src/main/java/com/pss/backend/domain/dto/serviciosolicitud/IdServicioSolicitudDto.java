package com.pss.backend.domain.dto.serviciosolicitud;

import lombok.Builder;

@Builder
public record IdServicioSolicitudDto(
    Integer idServicio,
    Integer idSolicitud
) {}
