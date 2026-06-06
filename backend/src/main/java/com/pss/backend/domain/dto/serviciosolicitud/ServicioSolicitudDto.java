package com.pss.backend.domain.dto.serviciosolicitud;

import lombok.Builder;

@Builder
public record ServicioSolicitudDto(
    IdServicioSolicitudDto idServicioSolicitud,
    String comentario,
    Double calificacion,
    Boolean aprovacionCliente,
    Boolean aprovacionProveedor,
    String pais,
    String provincia,
    String distrito,
    String direccion,
    Integer cantidad,
    Double precio_total,
    Short estado
) {}
