package com.pss.backend.domain.entity;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;

    @Column(nullable = false, unique = true, columnDefinition = "Varchar(255) NOT NULL")
    private String rol;

    @Builder.Default
    @Column( nullable = false, columnDefinition = "Varchar(255) default 'Sin descripcion' NOT NULL")
    private String descripcion = "Sin descripcion";

    @Builder.Default
    @Column(nullable = false, columnDefinition = "boolean default true NOT NULL")
    private Boolean activo=true;

    
    @OneToMany(mappedBy = "rol", fetch = FetchType.LAZY)
    private List<Usuario> usuarios;


}   