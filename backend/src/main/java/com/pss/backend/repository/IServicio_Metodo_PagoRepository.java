package com.pss.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pss.backend.domain.entity.servicios_metodos_pago;
import com.pss.backend.domain.entity.servicios_metodos_pago_Id;

public interface IServicio_Metodo_PagoRepository extends JpaRepository<servicios_metodos_pago, servicios_metodos_pago_Id> {

}
