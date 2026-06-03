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
@Table(name = "proveedores")
@Getter
@Setter
public class Proveedores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProveedor;

    @Column(unique = true, nullable = false)
    private String documentoProveedor;
    
    private String nombreProveedor;
    private String descripcion;
    private Double calificacionGeneral;
    private Short estado;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuario;

    @OneToMany(mappedBy="proveedor")
    private List<Horarios> horarios;

    @OneToMany(mappedBy="proveedor")
    private List<Servicios> servicios;

}
