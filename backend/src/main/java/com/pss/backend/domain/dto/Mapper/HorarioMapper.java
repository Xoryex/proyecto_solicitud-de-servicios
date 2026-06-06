package com.pss.backend.domain.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import com.pss.backend.domain.dto.horario.HorarioDto;
import com.pss.backend.domain.entity.Horario;
import com.pss.backend.domain.entity.Proveedor;
import com.pss.backend.repository.IProveedorRepository;

@Mapper(componentModel = "spring", uses = {IdHorarioMapper.class})
public abstract class HorarioMapper {

    @Autowired
    protected IProveedorRepository proveedorRepository;

    public abstract HorarioDto toDto(Horario entity);

    @Mapping(source = "idHorario.idProveedor", target = "proveedor")
    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    public abstract Horario toEntity(HorarioDto dto);

    @Mapping(target = "idHorario", ignore = true)
    @Mapping(target = "proveedor", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateEntity(HorarioDto dto, @MappingTarget Horario entity);

    protected Proveedor idToProveedor(Integer idProveedor) {
        return idProveedor != null ? proveedorRepository.getReferenceById(idProveedor) : null;
    }
}
