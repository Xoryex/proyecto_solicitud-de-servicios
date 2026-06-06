package com.pss.backend.domain.dto.permiso;

import lombok.Builder;

@Builder
public record IdPermisoDto(
        String modulo,
        Integer idRol
    ){}
