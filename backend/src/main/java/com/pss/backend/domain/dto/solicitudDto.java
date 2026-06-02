package com.pss.backend.domain.dto;

import java.util.List;

public record solicitudDto (
    Integer id_solicitud,
    Short estado,
    String comentario,
    Double calificacion,
    clienteDto cliente,
    List<servicio_solicitudDto> servicios_solicitudes
){}

