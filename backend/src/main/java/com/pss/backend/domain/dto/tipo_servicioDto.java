package com.pss.backend.domain.dto;

import java.util.List;

public record tipo_servicioDto (
    Integer id_tipo_servicio,
    String tipo_servicio,
    String descripcion,
    Short estado,
    List<servicioDto> servicios
) {}