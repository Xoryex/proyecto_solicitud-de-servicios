package com.pss.backend.services.IServices;

import com.pss.backend.domain.dto.cliente.ClienteCreateDto;
import com.pss.backend.domain.dto.cliente.ClienteDto;

public interface IClienteService extends ICRUDService <ClienteCreateDto, ClienteDto, ClienteDto, Integer>{

}
