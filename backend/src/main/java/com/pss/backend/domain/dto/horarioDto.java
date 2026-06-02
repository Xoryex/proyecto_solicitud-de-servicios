package com.pss.backend.domain.dto;

import java.time.LocalTime;



public record horarioDto(
    horarioIdDto id,

    LocalTime inicio_mañana,
    LocalTime fin_mañana,
    LocalTime inicio_tarde,
    LocalTime fin_tarde,
    Boolean activo,

    proveedorDto proveedor) {}


