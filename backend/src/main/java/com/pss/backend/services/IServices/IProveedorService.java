package com.pss.backend.services.IServices;

import com.pss.backend.domain.dto.proveedor.ProveedorCreateDto;
import com.pss.backend.domain.dto.proveedor.ProveedorDto;

public interface IProveedorService extends ICRUDService<ProveedorCreateDto, ProveedorDto, ProveedorDto, Integer> {
}
