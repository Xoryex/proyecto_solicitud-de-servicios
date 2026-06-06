package com.pss.backend.domain.dto.usuario;

import lombok.Builder;

@Builder
public record UsuarioCreateDto(
    String usuario,
    String password,
    Boolean activo,
    Integer idRol
) {}
