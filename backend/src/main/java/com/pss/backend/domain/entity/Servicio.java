package com.pss.backend.domain.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="servicios")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idServicio;

    @Column(nullable = false)
    private String titulo;
    @Builder.Default
    @Column(nullable = false, columnDefinition = "Varchar(255) default 'Sin descripcion'")
    private String descripcion = "Sin descripcion";

    private String pais;
    private String provincia;
    private String distrito;

    @Column(nullable = false)
    private String img;

    @Column(nullable = false)
    private double precio;

    @Builder.Default
    @Column(nullable = false, columnDefinition = "bit default 1")
    private Boolean activo = true;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_tipo_servicio")
    private TipoServicio tipoServicio;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_proveedor")
    private Proveedor proveedor;

    @OneToMany(mappedBy = "servicio", fetch=FetchType.LAZY)
    private List<ServicioSolicitud> serviciosSolicitudes;

    @OneToMany(mappedBy = "servicio", fetch=FetchType.LAZY)
    private List<ServicioMetodoPago> serviciosMetodosPago;

}
