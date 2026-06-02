package com.pss.backend.domain.dto;


public class permisoDto{

    public record update(
        permisoDto.id id,
        Boolean activo
    ) {}

    public record id(
        String modulo,
        Integer idRol
    ){}

    public record response(
        permisoDto.id id,
        boolean activo
    ){}

    public record create(
        permisoDto.id id,
        Boolean activo
    ) {
            public create{
                if(activo == null)
                    activo = true;
            }
    }

}