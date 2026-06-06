package com.pss.backend.domain.dto.metodopago;

import lombok.Builder;

@Builder
public record MetodoPagoDto (
    Integer idMetodoPago,
    String metodoPago,
    String descripcion
){}
