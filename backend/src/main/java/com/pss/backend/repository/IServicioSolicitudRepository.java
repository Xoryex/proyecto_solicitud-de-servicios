package com.pss.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pss.backend.domain.entity.ServicioSolicitud;
import com.pss.backend.domain.entity.IdServicioSolicitud;


@Repository
public interface IServicioSolicitudRepository extends JpaRepository<ServicioSolicitud, IdServicioSolicitud> {

    List<ServicioSolicitud> findByIdServicioSolicitud_IdServicioOrIdServicioSolicitud_IdSolicitud(Integer idServicio, Integer idSolicitud);

}
