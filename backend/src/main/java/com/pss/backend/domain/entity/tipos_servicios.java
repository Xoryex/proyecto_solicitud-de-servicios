package com.pss.backend.domain.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipos_servicios")
@Getter
@Setter
public class tipos_servicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipo_servicio;

    @Column(nullable = false, unique = true)
    private String tipo_servicio;

    private String descripcion;
    private Short estado;

    @OneToMany(mappedBy = "tipo_servicio")
    private List<servicios> servicios;

}
