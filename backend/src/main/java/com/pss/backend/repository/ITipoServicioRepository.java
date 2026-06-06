package com.pss.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pss.backend.domain.entity.TipoServicio;

public interface ITipoServicioRepository extends JpaRepository<TipoServicio, Integer> {

    boolean existsByTipoServicio(String tipoServicio);

    int countByIdTipoServicioOrTipoServicio(Integer id, String tipoServicio);
}
