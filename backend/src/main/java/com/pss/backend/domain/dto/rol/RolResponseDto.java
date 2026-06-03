package com.pss.backend.domain.dto.rol;

public record RolResponseDto (
        Integer idRol,
        String rol, 
        String descripcion,
        Boolean activo
    ){}