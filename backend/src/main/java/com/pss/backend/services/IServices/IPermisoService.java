package com.pss.backend.services.IServices;

import java.util.List;

import com.pss.backend.domain.dto.permiso.PermisoCreateDto;
import com.pss.backend.domain.dto.permiso.PermisoUpdateDto;
import com.pss.backend.domain.dto.permiso.PermisoResponseDto;
import com.pss.backend.domain.dto.permiso.PermisoIdDto;

public interface IPermisoService extends ICRUDService<PermisoCreateDto, PermisoUpdateDto, PermisoResponseDto, PermisoIdDto>{ 
    
    List<PermisoResponseDto> findByModulosOrIdRol(PermisoIdDto id);
}
