package com.pss.backend.domain.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import com.pss.backend.domain.dto.servicio.ServicioCreateDto;
import com.pss.backend.domain.dto.servicio.ServicioDto;
import com.pss.backend.domain.entity.Servicio;
import com.pss.backend.domain.entity.TipoServicio;
import com.pss.backend.domain.entity.Proveedor;
import com.pss.backend.repository.ITipoServicioRepository;
import com.pss.backend.repository.IProveedorRepository;

@Mapper(componentModel = "spring")
public abstract class ServicioMapper {

    @Autowired
    protected ITipoServicioRepository tipoServicioRepository;

    @Autowired
    protected IProveedorRepository proveedorRepository;

    @Mapping(target = "idServicio", ignore = true)
    @Mapping(target = "serviciosSolicitudes", ignore = true)
    @Mapping(target = "serviciosMetodosPago", ignore = true)
    @Mapping(source = "idTipoServicio", target = "tipoServicio")
    @Mapping(source = "idProveedor", target = "proveedor")
    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    public abstract Servicio toEntity(ServicioCreateDto dto);

    @Mapping(source = "tipoServicio.idTipoServicio", target = "idTipoServicio")
    @Mapping(source = "proveedor.idProveedor", target = "idProveedor")
    public abstract ServicioDto toDto(Servicio entity);

    @Mapping(target = "idServicio", ignore = true)
    @Mapping(target = "serviciosSolicitudes", ignore = true)
    @Mapping(target = "serviciosMetodosPago", ignore = true)
    @Mapping(source = "idTipoServicio", target = "tipoServicio")
    @Mapping(source = "idProveedor", target = "proveedor")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateEntity(ServicioCreateDto dto, @MappingTarget Servicio entity);

    @Mapping(target = "idServicio", ignore = true)
    @Mapping(target = "serviciosSolicitudes", ignore = true)
    @Mapping(target = "serviciosMetodosPago", ignore = true)
    @Mapping(source = "idTipoServicio", target = "tipoServicio")
    @Mapping(source = "idProveedor", target = "proveedor")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateEntityFromDto(ServicioDto dto, @MappingTarget Servicio entity);

    protected TipoServicio idToTipoServicio(Integer idTipoServicio) {
        return idTipoServicio != null ? tipoServicioRepository.getReferenceById(idTipoServicio) : null;
    }

    protected Proveedor idToProveedor(Integer idProveedor) {
        return idProveedor != null ? proveedorRepository.getReferenceById(idProveedor) : null;
    }
}
