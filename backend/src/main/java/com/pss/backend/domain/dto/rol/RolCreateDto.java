package com.pss.backend.domain.dto.rol;

public record RolCreateDto(
        String rol,
        String descripcion,
        Boolean activo
    ) {
            public RolCreateDto{
                if(descripcion == null)
                    descripcion = "Sin descripcion";
                if(activo == null)
                    activo = true;
            }
    }
