package com.pss.backend.services.IServices;

import com.pss.backend.domain.dto.rol.RolCreateDto;
import com.pss.backend.domain.dto.rol.RolResponseDto;
import com.pss.backend.domain.dto.rol.RolUpdateDto;


public interface IRolService extends ICRUDService<RolCreateDto, RolUpdateDto, RolResponseDto, Integer>{

}
