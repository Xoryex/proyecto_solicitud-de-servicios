package com.pss.backend.domain.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Servicios_MetodosPago_Id implements Serializable
{
    private Integer idServicio;
    private Integer idMetodoPago;
}