package com.pss.backend.services.IServices;

import java.util.List;
import com.pss.backend.domain.dto.solicitud.SolicitudCreateDto;
import com.pss.backend.domain.dto.solicitud.SolicitudDto;

public interface ISolicitudService extends ICRUDService<SolicitudCreateDto, SolicitudDto, SolicitudDto, Integer> {
    List<SolicitudDto> findByIdOrIdCliente (Integer id,Integer idCliente);
}
