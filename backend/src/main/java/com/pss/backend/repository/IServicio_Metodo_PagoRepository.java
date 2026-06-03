package com.pss.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pss.backend.domain.entity.Servicios_MetodosPago;
import com.pss.backend.domain.entity.Servicios_MetodosPago_Id;

public interface IServicio_Metodo_PagoRepository extends JpaRepository<Servicios_MetodosPago, Servicios_MetodosPago_Id> {

}
