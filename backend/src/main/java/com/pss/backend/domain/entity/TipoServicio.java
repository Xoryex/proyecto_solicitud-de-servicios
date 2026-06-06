package com.pss.backend.domain.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "tipos_servicios")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoServicio;

    @Column(nullable = false, unique = true)
    private String tipoServicio;

    private String descripcion;
    @Builder.Default
    @Column(nullable = false)
    private Short estado = 1;

    @OneToMany(mappedBy = "tipoServicio")
    private List<Servicio> servicios;

}
