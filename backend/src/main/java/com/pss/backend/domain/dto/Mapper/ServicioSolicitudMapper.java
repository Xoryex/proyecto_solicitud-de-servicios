package com.pss.backend.domain.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import com.pss.backend.domain.dto.serviciosolicitud.ServicioSolicitudDto;
import com.pss.backend.domain.entity.ServicioSolicitud;
import com.pss.backend.domain.entity.Servicio;
import com.pss.backend.domain.entity.Solicitud;
import com.pss.backend.repository.IServicioRepository;
import com.pss.backend.repository.ISolicitudRepository;

@Mapper(componentModel = "spring", uses = {IdServicioSolicitudMapper.class})
public abstract class ServicioSolicitudMapper {

    @Autowired
    protected IServicioRepository servicioRepository;

    @Autowired
    protected ISolicitudRepository solicitudRepository;

    public abstract ServicioSolicitudDto toDto(ServicioSolicitud entity);

    @Mapping(source = "idServicioSolicitud.idServicio", target = "servicio")
    @Mapping(source = "idServicioSolicitud.idSolicitud", target = "solicitud")
    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    public abstract ServicioSolicitud toEntity(ServicioSolicitudDto dto);

    @Mapping(target = "idServicioSolicitud", ignore = true)
    @Mapping(target = "servicio", ignore = true)
    @Mapping(target = "solicitud", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateEntity(ServicioSolicitudDto dto, @MappingTarget ServicioSolicitud entity);

    protected Servicio idToServicio(Integer idServicio) {
        return idServicio != null ? servicioRepository.getReferenceById(idServicio) : null;
    }

    protected Solicitud idToSolicitud(Integer idSolicitud) {
        return idSolicitud != null ? solicitudRepository.getReferenceById(idSolicitud) : null;
    }
}
