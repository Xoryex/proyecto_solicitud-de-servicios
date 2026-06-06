package com.pss.backend.domain.dto.permiso;

import lombok.Builder;

@Builder
 public record PermisoDto(
        IdPermisoDto idPermiso,
        Boolean activo
    ){}
