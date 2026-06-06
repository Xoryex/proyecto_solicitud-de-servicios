package com.pss.backend.services.IServices;

import com.pss.backend.domain.dto.serviciosolicitud.ServicioSolicitudDto;

import java.util.List;

import com.pss.backend.domain.dto.serviciosolicitud.IdServicioSolicitudDto;

public interface IServicioSolicitudService extends ICRUDService<ServicioSolicitudDto, ServicioSolicitudDto, ServicioSolicitudDto, IdServicioSolicitudDto> {

    List<ServicioSolicitudDto> findByIdServicioOrIdSolicitud(Integer idServicio, Integer idSolicitud);

}
