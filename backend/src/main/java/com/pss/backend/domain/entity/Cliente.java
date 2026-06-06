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
@Table(name="clientes")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    @Column(nullable = false, unique = true, length = 20)
    private String documentoCliente;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    private String pais;
    private String provincia;
    private String distrito;
    private String direccion;
    
    @Builder.Default
    @Column(nullable = false, columnDefinition = "smallint default 1")
    private Short estado = 1;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy="cliente", fetch = FetchType.LAZY )
    private List<Solicitud> solicitudes;

}
