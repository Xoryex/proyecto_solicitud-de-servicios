package com.pss.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pss.backend.domain.entity.Clientes;

public interface IClienteRepository extends JpaRepository<Clientes, Integer> {

}
