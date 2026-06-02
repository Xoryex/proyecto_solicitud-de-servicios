package com.pss.backend.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pss.backend.domain.entity.roles;

public interface IRolRepository extends JpaRepository<roles, Integer> {

    Optional<roles> findByRol(String rol);
    boolean existsByRol(String rol);

    // @Query(value = "select * from roles as r where r.id_rol like %:#{#rol.id_rol}% or r.rol like %:#{#rol.rol}% or r.descripcion like %:#{#rol.descripcion}% or r.activo like %:#{#rol.activo}%", nativeQuery = true)
    // List<roles> filter(@Param("rol")roles rol);

}
