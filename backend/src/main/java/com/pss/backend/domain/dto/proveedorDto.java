package com.pss.backend.domain.dto;

import java.util.List;

public record proveedorDto (
    Integer id_proveedor,
    String documento_proveedor,
    String nombre_proveedor,
    String descripcion,
    Double calificacion_general,
    Short estado,
    usuarioDto usuario,
    List<horarioDto> horarios,
    List<servicioDto> servicios
){}