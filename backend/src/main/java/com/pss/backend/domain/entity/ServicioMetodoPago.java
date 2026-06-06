package com.pss.backend.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "servicios_metodos_pago")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicioMetodoPago {

    @EmbeddedId
    private IdServicioMetodoPago idServicioMetodoPago;

    @Builder.Default
    @Column(nullable = false, columnDefinition = "bit default 1")
    private Boolean activo = true;

    @ManyToOne(fetch=FetchType.LAZY)
    @MapsId("idServicio")
    @JoinColumn(name ="id_servicio")
    private Servicio servicio;

    @ManyToOne(fetch=FetchType.LAZY)
    @MapsId("idMetodoPago")
    @JoinColumn(name = "id_metodo_pago")
    private MetodoPago metodoPago;

}

