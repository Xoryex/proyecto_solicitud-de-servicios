package com.pss.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pss.backend.domain.entity.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

    boolean existsByDocumentoCliente(String documentoCliente);

    int countByIdClienteOrDocumentoCliente(Integer id, String documentoCliente);
    
}
