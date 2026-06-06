package com.pss.backend.domain.dto.proveedor;

import lombok.Builder;

@Builder
public record ProveedorDto(
    Integer idProveedor,
    String documentoProveedor,
    String nombreProveedor,
    String descripcion,
    Double calificacionGeneral,
    Short estado,
    Integer idUsuario
) {
}
