package com.pss.backend.domain.dto;

import java.util.List;


public record clienteDto (
    Integer id_cliente,
    String documento_cliente,
    String nombre,
    String apellido,
    String pais,
    String provincia,
    String distrito,
    String direccion,
    Short estado,
    usuarioDto usuario,
    List<solicitudDto> solicitudes
){}
