package com.pss.backend.domain.dto;

import java.util.List;

public record TipoServicioDto (
    Integer idTipoServicio,
    String tipoServicio,
    String descripcion,
    Short estado,
    List<ServicioDto> servicios
) {}