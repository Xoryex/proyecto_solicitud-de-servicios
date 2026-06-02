package com.pss.backend.domain.dto;

import java.util.List;



public record metodo_pagoDto (


    Integer id_metodo_pago,

    String metodo_pago,

    String descricion,

    List<servicio_metodo_pagoDto> servicios_metodos_pago
){}
