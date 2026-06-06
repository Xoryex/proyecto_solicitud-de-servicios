package com.pss.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pss.backend.domain.entity.Proveedor;

public interface IProveedorRepository extends JpaRepository<Proveedor, Integer> {

    boolean existsByDocumentoProveedor(String documentoProveedor);

    int countByIdProveedorOrDocumentoProveedor(Integer id, String documentoProveedor);
}
