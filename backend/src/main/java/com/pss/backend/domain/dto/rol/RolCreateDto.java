package com.pss.backend.domain.dto.rol;

import lombok.Builder;

@Builder
public record RolCreateDto(
        String rol,
        String descripcion,
        Boolean activo
    ) {}
