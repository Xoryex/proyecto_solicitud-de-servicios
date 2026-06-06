package com.pss.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pss.backend.domain.entity.Solicitud;

@Repository
public interface ISolicitudRepository extends JpaRepository<Solicitud, Integer> {

    List<Solicitud> findByIdSolicitudOrCliente_IdCliente(Integer idSolicitud, Integer idCliente);
}
