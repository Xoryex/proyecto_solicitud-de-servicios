package com.pss.backend.domain.dto;

public record Servicio_SolicitudDto (
    Servicio_Solicitud_IdDto idServicioSolicitud,
    Integer cantidad,
    Short estado,
    ServicioDto servicio,
    SolicitudDto solicitud
){}

