package com.pss.backend.domain.dto;

import java.util.List;



public record MetodoPagoDto (


    Integer idMetodoPago,

    String metodoPago,

    String descripcion,

    List<Servicio_MetodoPagoDto> servicios_MetodosPago
){}
