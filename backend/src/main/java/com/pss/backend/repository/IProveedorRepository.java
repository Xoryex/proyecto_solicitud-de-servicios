package com.pss.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pss.backend.domain.entity.Proveedores;

public interface IProveedorRepository extends JpaRepository<Proveedores, Integer> {

}
