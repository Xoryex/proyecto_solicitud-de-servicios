package com.pss.backend.domain.entity;

import java.time.LocalTime;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="horarios")
@Getter
@Setter
public class Horarios {

    @EmbeddedId
    private HorariosId idHorario;

    private LocalTime inicioMañana;
    private LocalTime finMañana;
    private LocalTime inicioTarde;
    private LocalTime finTarde;
    private Boolean activo;

    @ManyToOne
    @MapsId("idProveedor")
    @JoinColumn(name="id_proveedor")
    private Proveedores proveedor;

}


