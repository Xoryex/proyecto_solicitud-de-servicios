package com.pss.backend.services.IServices;

import java.util.List;
import com.pss.backend.domain.dto.servicio.ServicioCreateDto;
import com.pss.backend.domain.dto.servicio.ServicioDto;

public interface IServicioService extends ICRUDService<ServicioCreateDto, ServicioDto, ServicioDto, Integer> {
    List<ServicioDto> findByIdOrProveedorOrTipoServicio(Integer id, Integer idProveedor, Integer idTipoServicio);
}
