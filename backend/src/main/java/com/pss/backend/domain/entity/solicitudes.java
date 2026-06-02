package com.pss.backend.domain.entity;

import java.util.List;

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
@Table(name = "solicitudes")
@Getter
@Setter
public class solicitudes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_solicitud;

    private Short estado;
    private String comentario;
    private Double calificacion;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    private clientes cliente;

    @OneToMany(mappedBy = "solicitud")
    private List<servicios_solicitudes> servicios_solicitudes;
}
