package com.pss.backend.domain.dto;

import java.util.List;


public record ClienteDto (
    Integer idCliente,
    String documentoCliente,
    String nombre,
    String apellido,
    String pais,
    String provincia,
    String distrito,
    String direccion,
    Short estado,
    UsuarioDto usuario,
    List<SolicitudDto> solicitudes
){}
