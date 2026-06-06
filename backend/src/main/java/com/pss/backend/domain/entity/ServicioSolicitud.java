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
@Table(name = "servicios_solicitudes")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicioSolicitud {

    @EmbeddedId
    private IdServicioSolicitud idServicioSolicitud;

    private String comentario;

    
    private Double calificacion;

    @Builder.Default
    @Column(nullable = false, columnDefinition = "bit default 0")
    private Boolean aprovacionCliente = false;
    
    @Builder.Default
    @Column(nullable = false, columnDefinition = "bit default 0")
    private Boolean aprovacionProveedor = false;

    @Column(nullable = false)
    private String pais;
    @Column(nullable = false)
    private String provincia;
    @Column(nullable = false)
    private String distrito;
    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private Integer cantidad;
    @Column(nullable = false)
    private Double precio_total;
    @Builder.Default
    @Column(nullable = false, columnDefinition = "smallint default 1")
    private Short estado = 1;

    @ManyToOne(fetch=FetchType.LAZY)
    @MapsId("idServicio")
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;

    @ManyToOne(fetch=FetchType.LAZY)
    @MapsId("idSolicitud")
    @JoinColumn(name = "id_solicitud")
    private Solicitud solicitud;
}

