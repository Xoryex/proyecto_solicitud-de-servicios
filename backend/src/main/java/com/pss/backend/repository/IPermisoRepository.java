package com.pss.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pss.backend.domain.entity.Permiso;
import com.pss.backend.domain.entity.IdPermiso;

@Repository
public interface IPermisoRepository extends JpaRepository<Permiso, IdPermiso> {

    
    Optional<List<Permiso>> findByIdPermiso_ModuloOrIdPermiso_IdRol(String modulo, Integer idRol);

}
