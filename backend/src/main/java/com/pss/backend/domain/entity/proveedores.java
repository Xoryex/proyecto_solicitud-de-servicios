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
public class proveedores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_proveedor;

    @Column(unique = true, nullable = false)
    private String documento_proveedor;
    
    private String nombre_proveedor;
    private String descripcion;
    private Double calificacion_general;
    private Short estado;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private usuarios usuario;

    @OneToMany(mappedBy="proveedor")
    private List<horarios> horarios;

    @OneToMany(mappedBy="proveedor")
    private List<servicios> servicios;

}
