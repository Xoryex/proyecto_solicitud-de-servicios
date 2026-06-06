package com.pss.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pss.backend.domain.entity.MetodoPago;

public interface IMetodoPagoRepository extends JpaRepository<MetodoPago, Integer> {

    boolean existsByMetodoPago(String metodoPago);
    
}
