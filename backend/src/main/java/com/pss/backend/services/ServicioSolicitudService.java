package com.pss.backend.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.pss.backend.domain.dto.serviciosolicitud.ServicioSolicitudDto;
import com.pss.backend.domain.dto.serviciosolicitud.IdServicioSolicitudDto;
import com.pss.backend.domain.dto.mapper.ServicioSolicitudMapper;
import com.pss.backend.domain.dto.mapper.IdServicioSolicitudMapper;
import com.pss.backend.domain.entity.ServicioSolicitud;
import com.pss.backend.domain.entity.IdServicioSolicitud;
import com.pss.backend.exceptions.ResourceDuplicate;
import com.pss.backend.exceptions.ResourceNotFound;
import com.pss.backend.repository.IServicioSolicitudRepository;
import com.pss.backend.services.IServices.IServicioSolicitudService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioSolicitudService implements IServicioSolicitudService {

    private final IServicioSolicitudRepository repository;
    private final ServicioSolicitudMapper mapper;
    private final IdServicioSolicitudMapper idMapper;

    @Override
    public ServicioSolicitudDto save(ServicioSolicitudDto dto) {
        IdServicioSolicitud id = idMapper.toEntity(dto.idServicioSolicitud());
        if (repository.existsById(id)) {
            throw new ResourceDuplicate("La relación servicio - solicitud ya existe");
        }
        ServicioSolicitud entity = mapper.toEntity(dto);
        entity.setIdServicioSolicitud(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public ServicioSolicitudDto findById(IdServicioSolicitudDto idDto) {
        IdServicioSolicitud id = idMapper.toEntity(idDto);
        ServicioSolicitud entity = repository.findById(id).orElseThrow(() -> new ResourceNotFound("Relación servicio - solicitud no encontrada"));
        return mapper.toDto(entity);
    }

    @Override
    public List<ServicioSolicitudDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public ServicioSolicitudDto update(ServicioSolicitudDto dto) {
        IdServicioSolicitud id = idMapper.toEntity(dto.idServicioSolicitud());
        ServicioSolicitud entity = repository.findById(id).orElseThrow(() -> new ResourceNotFound("Relación servicio - solicitud no encontrada"));
        mapper.updateEntity(dto, entity);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deleteById(IdServicioSolicitudDto idDto) {
        IdServicioSolicitud id = idMapper.toEntity(idDto);
        if (!repository.existsById(id)) {
            throw new ResourceNotFound("Relación servicio - solicitud no encontrada");
        }
        repository.deleteById(id);
    }

    @Override
    public List<ServicioSolicitudDto> findByIdServicioOrIdSolicitud(Integer idServicio, Integer idSolicitud) 
    {
        List<ServicioSolicitud> serviciosSolicitudes = repository.findByIdServicioSolicitud_IdServicioOrIdServicioSolicitud_IdSolicitud(idServicio, idSolicitud);
        
        return serviciosSolicitudes.stream().map(mapper::toDto).toList();
    }
}
