package com.pss.backend.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.pss.backend.domain.dto.servicio.ServicioCreateDto;
import com.pss.backend.domain.dto.servicio.ServicioDto;
import com.pss.backend.domain.dto.mapper.ServicioMapper;
import com.pss.backend.domain.entity.Servicio;
import com.pss.backend.exceptions.ResourceNotFound;
import com.pss.backend.repository.IServicioRepository;
import com.pss.backend.services.IServices.IServicioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioService implements IServicioService {

    private final IServicioRepository repository;
    private final ServicioMapper mapper;

    @Override
    public ServicioDto save(ServicioCreateDto dto) {
        Servicio servicio = mapper.toEntity(dto);
        return mapper.toDto(repository.save(servicio));
    }

    @Override
    public ServicioDto findById(Integer id) {
        Servicio servicio = repository.findById(id).orElseThrow(() -> new ResourceNotFound("Servicio no encontrado"));
        return mapper.toDto(servicio);
    }

    @Override
    public List<ServicioDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public ServicioDto update(ServicioDto dto) {
        Servicio servicio = repository.findById(dto.idServicio()).orElseThrow(() -> new ResourceNotFound("Servicio no encontrado"));
        mapper.updateEntityFromDto(dto, servicio);
        return mapper.toDto(repository.save(servicio));
    }

    @Override
    public void deleteById(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFound("Servicio no encontrado");
        }
        repository.deleteById(id);
    }

    @Override
    public List<ServicioDto> findByIdOrProveedorOrTipoServicio(Integer id, Integer idProveedor, Integer idTipoServicio)
    {
        List<Servicio> servicios = repository.findByIdServicioOrProveedor_IdProveedorOrTipoServicio_IdTipoServicio(id, idProveedor, idTipoServicio);
        
        return servicios.stream().map(mapper::toDto).toList();
    }
}
