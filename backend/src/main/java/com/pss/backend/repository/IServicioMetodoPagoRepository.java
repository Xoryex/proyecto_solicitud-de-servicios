package com.pss.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pss.backend.domain.entity.ServicioMetodoPago;
import com.pss.backend.domain.entity.IdServicioMetodoPago;

@Repository
public interface IServicioMetodoPagoRepository extends JpaRepository<ServicioMetodoPago, IdServicioMetodoPago> {

    List<ServicioMetodoPago> findByIdServicioMetodoPago_IdServicioOrIdServicioMetodoPago_IdServicio(Integer idServicio,Integer idMetodoPago);

}
