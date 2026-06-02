package com.pss.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pss.backend.domain.entity.permisos;
import com.pss.backend.domain.entity.permisosId;

@Repository
public interface IPermisoRepository extends JpaRepository<permisos, permisosId> {

    
    Optional<List<permisos>> findByIdModuloOrIdIdRol(String modulo, Integer idRol);

}
