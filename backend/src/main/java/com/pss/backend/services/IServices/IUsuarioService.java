package com.pss.backend.services.IServices;

import com.pss.backend.domain.dto.usuario.UsuarioCreateDto;
import com.pss.backend.domain.dto.usuario.UsuarioDto;


public interface IUsuarioService extends ICRUDService <UsuarioCreateDto, UsuarioDto, UsuarioDto, Integer> {

}
