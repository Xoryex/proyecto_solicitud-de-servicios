package com.pss.backend.service.IService;

import java.util.List;

import com.pss.backend.domain.dto.permisoDto;

public interface IPermisoService extends ICRUDService<permisoDto.create, permisoDto.update, permisoDto.response, permisoDto.id>{ 
    
    
    List<permisoDto.response> findByModulosOrIdRol(permisoDto.id id);
}
