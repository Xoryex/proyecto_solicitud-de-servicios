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
@Table(name = "metodos_pago")
@Getter
@Setter
public class metodos_pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_metodo_pago;

    @Column(unique=true, nullable=false)
    private String metodo_pago;

    private String descricion;

    @OneToMany(mappedBy = "metodo_pago")
    private List<servicios_metodos_pago> servicios_metodos_pago;
}
