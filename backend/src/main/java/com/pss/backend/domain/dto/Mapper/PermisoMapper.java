package com.pss.backend.domain.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import com.pss.backend.domain.dto.permiso.PermisoDto;
import com.pss.backend.domain.entity.Permiso;
import com.pss.backend.domain.entity.Rol;
import com.pss.backend.repository.IRolRepository;


@Mapper(componentModel = "spring", uses ={IdPermisoMapper.class})
public abstract class PermisoMapper {

    @Autowired
    protected IRolRepository rolRepository;

    public abstract PermisoDto toDTO(Permiso permiso);

    @Mapping(source = "idPermiso.idRol",target = "rol")
    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    public abstract Permiso toEntity(PermisoDto permisoDto);

    @Mapping(target = "idPermiso", ignore = true)
    @Mapping(target = "rol", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateEntity(PermisoDto permisoDto, @MappingTarget Permiso permiso);

    protected Rol idToRol(Integer idRol) {
        return rolRepository.getReferenceById(idRol);
    }
}