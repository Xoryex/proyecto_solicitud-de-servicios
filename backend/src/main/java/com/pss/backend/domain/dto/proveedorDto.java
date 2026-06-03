package com.pss.backend.domain.dto;

import java.util.List;

public record ProveedorDto (
    Integer idProveedor,
    String documentoProveedor,
    String nombreProveedor,
    String descripcion,
    Double calificacionGeneral,
    Short estado,
    UsuarioDto usuario,
    List<HorarioDto> horarios,
    List<ServicioDto> servicios
){}