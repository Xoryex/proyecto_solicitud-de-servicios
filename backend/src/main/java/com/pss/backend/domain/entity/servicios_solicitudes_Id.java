package com.pss.backend.domain.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class servicios_solicitudes_Id implements Serializable
{

    private Integer id_servicio;
    private Integer id_solicitud;

}