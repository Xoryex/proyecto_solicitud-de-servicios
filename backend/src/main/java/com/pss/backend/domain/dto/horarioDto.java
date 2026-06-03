package com.pss.backend.domain.dto;

import java.time.LocalTime;



public record HorarioDto(
    HorarioIdDto idHorario,

    LocalTime inicioMañana,
    LocalTime finMañana,
    LocalTime inicioTarde,
    LocalTime finTarde,
    Boolean activo,

    ProveedorDto proveedor) {}


