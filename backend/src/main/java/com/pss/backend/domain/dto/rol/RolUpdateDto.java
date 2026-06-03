package com.pss.backend.domain.dto.rol;

public record RolUpdateDto(
        Integer idRol,
        String rol,
        String descripcion,
        Boolean activo
    ){}
