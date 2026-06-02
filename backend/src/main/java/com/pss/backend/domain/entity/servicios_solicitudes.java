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
public class servicios_solicitudes {

    @EmbeddedId
    private servicios_solicitudes_Id id;

    private Integer cantidad;
    private Short estado;

    @ManyToOne
    @MapsId("id_servicio")
    @JoinColumn(name = "id_servicio")
    private servicios servicio;

    @ManyToOne
    @MapsId("id_solicitud")
    @JoinColumn(name = "id_solicitud")
    private solicitudes solicitud;
}

