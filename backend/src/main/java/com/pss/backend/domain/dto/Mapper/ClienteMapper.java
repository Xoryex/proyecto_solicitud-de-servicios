package com.pss.backend.domain.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import com.pss.backend.domain.dto.cliente.ClienteCreateDto;
import com.pss.backend.domain.dto.cliente.ClienteDto;
import com.pss.backend.domain.entity.Cliente;
import com.pss.backend.domain.entity.Usuario;
import com.pss.backend.repository.IUsuarioRepository;

@Mapper(componentModel = "spring")
public abstract class ClienteMapper{

    @Autowired
    protected IUsuarioRepository usuarioRepository;


    @Mapping(target = "idCliente", ignore = true)
    @Mapping(source = "idUsuario", target = "usuario")
    @Mapping(target = "solicitudes", ignore = true)
    @BeanMapping(nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
    public abstract Cliente toEntity(ClienteCreateDto clienteCreateDTO);

    @Mapping(source = "usuario.idUsuario", target = "idUsuario")
    public abstract ClienteDto toDto(Cliente cliente);

    @Mapping(target = "solicitudes", ignore = true)
    @Mapping(source = "idUsuario", target = "usuario")
    public abstract void updateEntity(ClienteDto clienteUpdateDTO, @MappingTarget Cliente cliente);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public Usuario idToUsuario(Integer idUsuario) {
        return usuarioRepository.getReferenceById(idUsuario);
    }

}
