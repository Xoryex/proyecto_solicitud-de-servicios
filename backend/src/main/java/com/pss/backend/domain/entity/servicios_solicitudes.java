package com.pss.backend.domain.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "servicios_solicitudes")
@Getter
@Setter
public class Servicios_Solicitudes {

    @EmbeddedId
    private Servicios_Solicitudes_Id idServicolioSolicitud;

    private Integer cantidad;
    private Short estado;

    @ManyToOne
    @MapsId("idServicio")
    @JoinColumn(name = "id_servicio")
    private Servicios servicio;

    @ManyToOne
    @MapsId("idSolicitud")
    @JoinColumn(name = "id_solicitud")
    private Solicitudes solicitud;
}

