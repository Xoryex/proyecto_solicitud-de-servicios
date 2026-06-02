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
@Table(name="clientes")
@Getter
@Setter
public class clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente;

    @Column(unique = true, nullable = false)
    private String documento_cliente;
    private String nombre;
    private String apellido;
    private String pais;
    private String provincia;
    private String distrito;
    private String direccion;
    private Short estado;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private usuarios usuario;

    @OneToMany(mappedBy="cliente")
    private List<solicitudes> solicitudes;

}
