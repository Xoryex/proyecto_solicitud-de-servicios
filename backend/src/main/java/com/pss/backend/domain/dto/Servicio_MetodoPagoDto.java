package com.pss.backend.domain.dto;


public record Servicio_MetodoPagoDto (

    Servicio_MetodoPago_IdDto idServicioMetodoPago,

    Boolean activo,

    ServicioDto servicio,

    MetodoPagoDto metodoPago
){}

