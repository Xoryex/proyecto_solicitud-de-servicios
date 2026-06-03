package com.pss.backend.domain.dto.permiso;

public record PermisoCreateDto(
        PermisoIdDto idPermiso,
        Boolean activo
    ) {
            public PermisoCreateDto{
                if(activo == null)
                    activo = true;
            }
    }
