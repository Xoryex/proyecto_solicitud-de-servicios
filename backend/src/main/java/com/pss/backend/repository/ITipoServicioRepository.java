package com.pss.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pss.backend.domain.entity.TiposServicios;

public interface ITipoServicioRepository extends JpaRepository<TiposServicios, Integer> {

}
