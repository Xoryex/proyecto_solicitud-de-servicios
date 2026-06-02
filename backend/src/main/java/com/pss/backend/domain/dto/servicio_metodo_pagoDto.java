package com.pss.backend.domain.dto;


public record servicio_metodo_pagoDto (

    servicio_metodo_pago_IdDto id,

    Boolean activo,

    servicioDto servicio,

    metodo_pagoDto metodo_pago
){}

