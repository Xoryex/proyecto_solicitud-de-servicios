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
@Table(name = "proveedores")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProveedor;

    @Column(unique = true, nullable = false)
    private String documentoProveedor;
    @Column(nullable = false)
    private String nombreProveedor;

    @Builder.Default
    @Column(nullable = false, columnDefinition="Varchar(255) default 'Sin descripcion' NOT NULL")
    private String descripcion = "Sin descripcion";

    private Double calificacionGeneral;

    @Builder.Default
    @Column(nullable = false, columnDefinition = "smallint default 1")
    private Short estado = 1;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy="proveedor",fetch=FetchType.LAZY)
    private List<Horario> horarios;

    @OneToMany(mappedBy="proveedor",fetch=FetchType.LAZY)
    private List<Servicio> servicios;

}
