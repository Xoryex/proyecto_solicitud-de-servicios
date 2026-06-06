package com.pss.backend.domain.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import com.pss.backend.domain.dto.solicitud.SolicitudCreateDto;
import com.pss.backend.domain.dto.solicitud.SolicitudDto;
import com.pss.backend.domain.entity.Solicitud;
import com.pss.backend.domain.entity.Cliente;
import com.pss.backend.repository.IClienteRepository;

@Mapper(componentModel = "spring")
public abstract class SolicitudMapper {

    @Autowired
    protected IClienteRepository clienteRepository;

    @Mapping(target = "idSolicitud", ignore = true)
    @Mapping(target = "serviciosSolicitudes", ignore = true)
    @Mapping(source = "idCliente", target = "cliente")
    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    public abstract Solicitud toEntity(SolicitudCreateDto dto);

    @Mapping(source = "cliente.idCliente", target = "idCliente")
    public abstract SolicitudDto toDto(Solicitud entity);

    @Mapping(target = "idSolicitud", ignore = true)
    @Mapping(target = "serviciosSolicitudes", ignore = true)
    @Mapping(source = "idCliente", target = "cliente")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateEntity(SolicitudDto dto, @MappingTarget Solicitud entity);


    protected Cliente idToCliente(Integer idCliente) {
        return idCliente != null ? clienteRepository.getReferenceById(idCliente) : null;
    }
}
