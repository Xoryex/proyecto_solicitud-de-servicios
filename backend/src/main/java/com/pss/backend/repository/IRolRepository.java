package com.pss.backend.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pss.backend.domain.entity.Rol;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByRol(String rol);
    boolean existsByRol(String rol);

    // @Query(value = "select * from roles as r where r.id_rol like %:#{#rol.id_rol}% or r.rol like %:#{#rol.rol}% or r.descripcion like %:#{#rol.descripcion}% or r.activo like %:#{#rol.activo}%", nativeQuery = true)
    // List<roles> filter(@Param("rol")roles rol);

}
