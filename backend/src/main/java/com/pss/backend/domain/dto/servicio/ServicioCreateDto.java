package com.pss.backend.domain.dto.servicio;

import lombok.Builder;

@Builder
public record ServicioCreateDto(
    String titulo,
    String descripcion,
    String pais,
    String distrito,
    String img,
    Double precio,
    Boolean activo,
    Integer idTipoServicio,
    Integer idProveedor
) {}
