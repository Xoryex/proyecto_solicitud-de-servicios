package com.pss.backend.domain.dto.serviciometodopago;

import lombok.Builder;

@Builder
public record ServicioMetodoPagoDto(
    IdServicioMetodoPagoDto idServicioMetodoPago,
    Boolean activo
) {}
