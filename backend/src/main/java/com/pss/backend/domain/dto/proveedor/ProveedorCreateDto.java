package com.pss.backend.domain.dto.proveedor;

import lombok.Builder;

@Builder
public record ProveedorCreateDto(
    String documentoProveedor,
    String nombreProveedor,
    String descripcion,
    Double calificacionGeneral,
    Short estado,
    Integer idUsuario
) {
}
