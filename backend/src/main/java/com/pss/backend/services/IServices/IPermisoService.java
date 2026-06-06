package com.pss.backend.services.IServices;

import java.util.List;

import com.pss.backend.domain.dto.permiso.PermisoDto;
import com.pss.backend.domain.dto.permiso.IdPermisoDto;

public interface IPermisoService extends ICRUDService<PermisoDto, PermisoDto, PermisoDto, IdPermisoDto>{ 
    
    List<PermisoDto> findByModulosOrIdRol(IdPermisoDto id);
}
