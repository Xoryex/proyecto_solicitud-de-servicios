package com.pss.backend.domain.dto;

public record servicio_solicitudDto (
    servicio_solicitud_IdDto id,
    Integer cantidad,
    Short estado,
    servicioDto servicio,
    solicitudDto solicitud
){}

