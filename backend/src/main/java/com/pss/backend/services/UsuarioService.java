package com.pss.backend.services;

import com.pss.backend.services.IServices.IUsuarioService;

import lombok.RequiredArgsConstructor;

import com.pss.backend.domain.dto.mapper.UsuarioMapper;
import com.pss.backend.domain.dto.usuario.UsuarioCreateDto;
import com.pss.backend.domain.dto.usuario.UsuarioDto;
import com.pss.backend.domain.entity.Usuario;
import com.pss.backend.exceptions.ResourceDuplicate;
import com.pss.backend.exceptions.ResourceNotFound;
import com.pss.backend.repository.IUsuarioRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {

    private final IUsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper;
    

    public UsuarioDto save( UsuarioCreateDto dto)
    {
        
        if(usuarioRepository.existsByUsuario(dto.usuario())) throw new ResourceDuplicate("El usuario ya existe");
        Usuario usuario = usuarioMapper.toEntity(dto);
        usuarioRepository.save(usuario);
        return usuarioMapper.toDto(usuario);
    }
    public UsuarioDto findById(Integer id)
    {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Usuario no encontrado"));

        return usuarioMapper.toDto(usuario);
    }
    public List<UsuarioDto> findAll()
    {
        List<Usuario> usuarios = usuarioRepository.findAll();

        return usuarios.stream().map(usuarioMapper::toDto).toList();
    }
    public UsuarioDto update(UsuarioDto dto)
    {
        Usuario usuario = usuarioRepository.findById(dto.idUsuario()).orElseThrow(() -> new ResourceNotFound("Usuario no encontrado"));

        usuarioMapper.updateEntity(dto, usuario);
        usuarioRepository.save(usuario);

        return usuarioMapper.toDto(usuario);
    }
    public void deleteById(Integer id)
    {
        if(!usuarioRepository.existsById(id)) throw new ResourceNotFound("Usuario no encontrado");

        usuarioRepository.deleteById(id);

    }

}
