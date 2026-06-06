package com.pss.backend.domain.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import com.pss.backend.domain.dto.serviciometodopago.ServicioMetodoPagoDto;
import com.pss.backend.domain.entity.ServicioMetodoPago;
import com.pss.backend.domain.entity.Servicio;
import com.pss.backend.domain.entity.MetodoPago;
import com.pss.backend.repository.IServicioRepository;
import com.pss.backend.repository.IMetodoPagoRepository;

@Mapper(componentModel = "spring", uses = {IdServicioMetodoPagoMapper.class})
public abstract class ServicioMetodoPagoMapper {

    @Autowired
    protected IServicioRepository servicioRepository;

    @Autowired
    protected IMetodoPagoRepository metodoPagoRepository;

    public abstract ServicioMetodoPagoDto toDto(ServicioMetodoPago entity);

    @Mapping(source = "idServicioMetodoPago.idServicio", target = "servicio")
    @Mapping(source = "idServicioMetodoPago.idMetodoPago", target = "metodoPago")
    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    public abstract ServicioMetodoPago toEntity(ServicioMetodoPagoDto dto);

    @Mapping(target = "idServicioMetodoPago", ignore = true)
    @Mapping(target = "servicio", source= "idServicioMetodoPago.idServicio")
    @Mapping(target = "metodoPago", source="idServicioMetodoPago.idMetodoPago")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateEntity(ServicioMetodoPagoDto dto, @MappingTarget ServicioMetodoPago entity);

    protected Servicio idToServicio(Integer idServicio) {
        return idServicio != null ? servicioRepository.getReferenceById(idServicio) : null;
    }

    protected MetodoPago idToMetodoPago(Integer idMetodoPago) {
        return idMetodoPago != null ? metodoPagoRepository.getReferenceById(idMetodoPago) : null;
    }
}
