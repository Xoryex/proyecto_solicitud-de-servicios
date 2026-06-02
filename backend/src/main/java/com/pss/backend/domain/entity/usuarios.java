package com.pss.backend.domain.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @Column(nullable = false, unique = true)
    private String usuario;

    private String contraseña;
    
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private roles rol;

    @OneToMany(mappedBy = "usuario")
    List<clientes> clientes;

    @OneToMany(mappedBy = "usuario")
    List<proveedores> proveedores;

}
