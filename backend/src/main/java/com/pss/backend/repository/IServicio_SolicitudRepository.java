package com.pss.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pss.backend.domain.entity.servicios_solicitudes;
import com.pss.backend.domain.entity.servicios_solicitudes_Id;



public interface IServicio_SolicitudRepository extends JpaRepository<servicios_solicitudes, servicios_solicitudes_Id> {

}
