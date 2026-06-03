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
public class Servicios_MetodosPago {

    @EmbeddedId
    private Servicios_MetodosPago_Id idServicioMetodoPago;

    private Boolean activo;

    @ManyToOne
    @MapsId("idServicio")
    @JoinColumn(name ="id_servicio")
    private Servicios servicio;

    @ManyToOne
    @MapsId("idMetodoPago")
    @JoinColumn(name = "id_metodo_pago")
    private MetodosPago metodoPago;

}

