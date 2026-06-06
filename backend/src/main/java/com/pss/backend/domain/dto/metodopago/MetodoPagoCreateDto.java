package com.pss.backend.domain.dto.metodopago;

import lombok.Builder;

@Builder
public record MetodoPagoCreateDto(
    String metodoPago,
    String descripcion
){}
