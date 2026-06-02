package com.pss.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pss.backend.domain.entity.clientes;

public interface IClienteRepository extends JpaRepository<clientes, Integer> {

}
