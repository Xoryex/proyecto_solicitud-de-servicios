package com.pss.backend.domain.entity;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="horarios")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Horario {

    @EmbeddedId
    private IdHorario idHorario;

    private LocalTime inicioMañana;
    private LocalTime finMañana;
    private LocalTime inicioTarde;
    private LocalTime finTarde;
    @Builder.Default
    @Column(nullable = false, columnDefinition = "bit default 1")
    private Boolean activo = true;

    @ManyToOne(fetch=FetchType.LAZY)
    @MapsId("idProveedor")
    @JoinColumn(name="id_proveedor")
    private Proveedor proveedor;

}


