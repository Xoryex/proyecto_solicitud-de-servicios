package com.pss.backend.domain.dto.rol;

import lombok.Builder;

@Builder
public record RolDto (
        Integer idRol,
        String rol, 
        String descripcion,
        Boolean activo
    ){}