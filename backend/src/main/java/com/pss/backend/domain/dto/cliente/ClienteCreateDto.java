package com.pss.backend.domain.dto.cliente;

import lombok.Builder;

@Builder
public record ClienteCreateDto (
    String documentoCliente,
    String nombre,
    String apellido,
    String pais,
    String provincia,
    String distrito,
    String direccion,
    Short estado,
    Integer idUsuario
){
}
