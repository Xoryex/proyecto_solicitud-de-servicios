package com.pss.backend.domain.dto.permiso;

public record PermisoUpdateDto(
        PermisoIdDto idPermiso,
        Boolean activo
    ) {}
