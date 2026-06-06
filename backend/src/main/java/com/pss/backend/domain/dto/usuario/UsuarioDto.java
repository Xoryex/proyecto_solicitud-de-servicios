package com.pss.backend.domain.dto.usuario;

import lombok.Builder;

@Builder
public record UsuarioDto(
    Integer idUsuario,
    String usuario,
    String password,
    Boolean activo,
    Integer idRol
) {
    

}
