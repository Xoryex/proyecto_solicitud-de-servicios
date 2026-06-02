package com.pss.backend.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;



@Entity
@Table(name = "permisos")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class permisos {

    @EmbeddedId
    private permisosId id;

    @Builder.Default
    @Column(nullable = false, columnDefinition = "boolean default true NOT NULL")
    private Boolean activo=true;

    @ManyToOne
    @MapsId("idRol")
    @JoinColumn(name = "id_rol")
    private roles rol;

}
