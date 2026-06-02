package com.pss.backend.domain.dto;

import java.util.List;

public record servicioDto (

    Integer id_servicio,
    String titulo,
    String descripcion,
    String pais,
    String provincia,
    String distrito,
    String direccion,
    String img,
    Double precio,
    tipo_servicioDto tipo_servicio,
    proveedorDto proveedor,
    List<servicio_solicitudDto> servicios_solicitudes,
    List<servicio_metodo_pagoDto> servicios_metodos_pago
){}