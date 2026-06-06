package com.pss.backend.domain.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import com.pss.backend.domain.dto.usuario.UsuarioCreateDto;
import com.pss.backend.domain.dto.usuario.UsuarioDto;
import com.pss.backend.domain.entity.Rol;
import com.pss.backend.domain.entity.Usuario;
import com.pss.backend.repository.IRolRepository;

@Mapper(componentModel = "spring")
public abstract class UsuarioMapper {

    @Autowired
    protected IRolRepository rolRepository;
    
    @Mapping(source = "rol.idRol", target = "idRol")
    public abstract UsuarioDto toDto(Usuario createDto);

    @Mapping(target = "clientes", ignore = true)
    @Mapping(target = "proveedores", ignore = true)
    @Mapping(target = "idUsuario", ignore = true)
    @Mapping(source = "idRol", target = "rol")
    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    public abstract Usuario toEntity(UsuarioCreateDto createDto);

    @Mapping(target = "clientes", ignore = true)
    @Mapping(target = "proveedores", ignore = true)
    @Mapping(source = "idRol", target = "rol")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateEntity(UsuarioDto updateDto, @MappingTarget Usuario usuario);

    protected Rol idToRol(Integer idRol) {
        return rolRepository.getReferenceById(idRol);
    }

}
