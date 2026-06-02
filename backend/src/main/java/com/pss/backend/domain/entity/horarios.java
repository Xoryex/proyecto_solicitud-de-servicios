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
public class horarios {

    @EmbeddedId
    private horariosId id;

    private LocalTime inicio_mañana;
    private LocalTime fin_mañana;
    private LocalTime inicio_tarde;
    private LocalTime fin_tarde;
    private Boolean activo;

    @ManyToOne
    @MapsId("id_proveedor")
    @JoinColumn(name="id_proveedor")
    private proveedores proveedor;

}


