package com.pss.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pss.backend.domain.entity.MetodosPago;

public interface IMetodo_PagoRepository extends JpaRepository<MetodosPago, Integer> {

}
