package com.pss.backend.domain.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import com.pss.backend.domain.dto.proveedor.ProveedorCreateDto;
import com.pss.backend.domain.dto.proveedor.ProveedorDto;
import com.pss.backend.domain.entity.Proveedor;
import com.pss.backend.domain.entity.Usuario;
import com.pss.backend.repository.IUsuarioRepository;


@Mapper(componentModel = "spring")
public abstract class ProveedorMapper {

    @Autowired
    protected IUsuarioRepository usuarioRepository;

    @Mapping(target = "idProveedor", ignore = true)
    @Mapping(target = "horarios", ignore = true)
    @Mapping(target = "servicios", ignore = true)
    @Mapping(target = "usuario", source = "idUsuario")
    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    public abstract Proveedor toEntity(ProveedorCreateDto dto);

    @Mapping(target = "idUsuario", source = "usuario.idUsuario")
    public abstract ProveedorDto toDto(Proveedor entity);

    @Mapping(target = "idProveedor", ignore = true)
    @Mapping(target = "horarios", ignore = true)
    @Mapping(target = "servicios", ignore = true)
    @Mapping(target = "usuario", source = "idUsuario")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateEntity(ProveedorDto dto, @MappingTarget Proveedor entity);

    protected Usuario idToUsuario(Integer idUsuario) {
        return usuarioRepository.getReferenceById(idUsuario);
    }

}
