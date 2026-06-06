package com.pss.backend.services.IServices;

import com.pss.backend.domain.dto.serviciometodopago.ServicioMetodoPagoDto;

import java.util.List;

import com.pss.backend.domain.dto.serviciometodopago.IdServicioMetodoPagoDto;

public interface IServicioMetodoPagoService extends ICRUDService<ServicioMetodoPagoDto, ServicioMetodoPagoDto, ServicioMetodoPagoDto, IdServicioMetodoPagoDto> {

    List<ServicioMetodoPagoDto> findByIdServicioOrIdServicio(Integer idServicio,Integer idMetodoPago);
}
