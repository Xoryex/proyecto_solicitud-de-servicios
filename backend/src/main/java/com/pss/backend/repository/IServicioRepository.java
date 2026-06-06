package com.pss.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pss.backend.domain.entity.Servicio;

@Repository
public interface IServicioRepository extends JpaRepository<Servicio, Integer> {

    List<Servicio> findByIdServicioOrProveedor_IdProveedorOrTipoServicio_IdTipoServicio(
        Integer id, 
        Integer idProveedor, 
        Integer idTipoServicio
    );
}
