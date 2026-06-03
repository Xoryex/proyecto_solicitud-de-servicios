package com.pss.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pss.backend.domain.entity.Servicios_Solicitudes;
import com.pss.backend.domain.entity.Servicios_Solicitudes_Id;



public interface IServicio_SolicitudRepository extends JpaRepository<Servicios_Solicitudes, Servicios_Solicitudes_Id> {

}
