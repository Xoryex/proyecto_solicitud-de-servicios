package com.pss.backend.domain.dto;

import java.util.List;

public record ServicioDto (

    Integer idServicio,
    String titulo,
    String descripcion,
    String pais,
    String provincia,
    String distrito,
    String direccion,
    String img,
    Double precio,
    TipoServicioDto tipoServicio,
    ProveedorDto proveedor,
    List<Servicio_SolicitudDto> servicios_solicitudes,
    List<Servicio_MetodoPagoDto> servicios_MetodosPagos
){}