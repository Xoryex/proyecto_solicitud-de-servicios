package com.pss.backend.domain.dto.serviciometodopago;

import lombok.Builder;

@Builder
public record IdServicioMetodoPagoDto(
    Integer idServicio,
    Integer idMetodoPago
) {}
