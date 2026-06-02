package com.pss.backend.domain.dto;


public class rolDto {

    public record response (
        Integer id,
        String rol, 
        String descripcion,
        Boolean activo
    ){}

    public record create(
        String rol,
        String descripcion,
        Boolean activo
    ) {
            public create{
                if(descripcion == null)
                    descripcion = "Sin descripcion";
                if(activo == null)
                    activo = true;
            }
    }

    public record update(
        Integer id,
        String rol,
        String descripcion,
        Boolean activo
    ){}


}