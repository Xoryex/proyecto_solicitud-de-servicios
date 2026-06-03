package com.pss.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pss.backend.domain.entity.Permisos;
import com.pss.backend.domain.entity.PermisosId;

@Repository
public interface IPermisoRepository extends JpaRepository<Permisos, PermisosId> {

    
    Optional<List<Permisos>> findByIdPermiso_ModuloOrIdPermiso_IdRol(String modulo, Integer idRol);

}
