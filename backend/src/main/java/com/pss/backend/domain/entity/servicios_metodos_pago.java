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
@Table(name = "servicios_metodos_pago")
@Getter
@Setter
public class servicios_metodos_pago {

    @EmbeddedId
    private servicios_metodos_pago_Id id;

    private Boolean activo;

    @ManyToOne
    @MapsId("id_servicio")
    @JoinColumn(name ="id_servicio")
    private servicios servicio;

    @ManyToOne
    @MapsId("id_metodo_pago")
    @JoinColumn(name = "id_metodo_pago")
    private metodos_pago metodo_pago;

}

