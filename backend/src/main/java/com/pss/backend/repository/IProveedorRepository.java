package com.pss.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pss.backend.domain.entity.proveedores;

public interface IProveedorRepository extends JpaRepository<proveedores, Integer> {

}
