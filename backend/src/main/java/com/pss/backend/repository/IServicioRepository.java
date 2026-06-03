package com.pss.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pss.backend.domain.entity.Servicios;

public interface IServicioRepository extends JpaRepository<Servicios, Integer> {

}
