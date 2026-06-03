package com.pss.backend.domain.dto;

import java.util.List;

public record SolicitudDto (
    Integer idSolicitud,
    Short estado,
    String comentario,
    Double calificacion,
    ClienteDto cliente,
    List<Servicio_SolicitudDto> servicios_solicitudes
){}

