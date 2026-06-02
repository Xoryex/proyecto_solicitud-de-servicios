package com.pss.backend.domain.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="servicios")
@Getter
@Setter
public class servicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_servicio;

    @Column(nullable = false)
    private String titulo;
    private String descripcion;
    private String pais;
    private String provincia;
    private String distrito;
    private String direccion;
    private String img;
    private double precio;

    @ManyToOne
    @JoinColumn(name="id_tipo_servicio")
    private tipos_servicios tipo_servicio;

    @ManyToOne
    @JoinColumn(name="id_proveedor")
    private proveedores proveedor;

    @OneToMany(mappedBy = "servicio")
    private List<servicios_solicitudes> servicios_solicitudes;

    @OneToMany(mappedBy = "servicio")
    private List<servicios_metodos_pago> servicios_metodos_pago;

}
