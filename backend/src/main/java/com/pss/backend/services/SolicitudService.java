package com.pss.backend.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.pss.backend.domain.dto.solicitud.SolicitudCreateDto;
import com.pss.backend.domain.dto.solicitud.SolicitudDto;
import com.pss.backend.domain.dto.mapper.SolicitudMapper;
import com.pss.backend.domain.entity.Solicitud;
import com.pss.backend.exceptions.ResourceNotFound;
import com.pss.backend.repository.ISolicitudRepository;
import com.pss.backend.services.IServices.ISolicitudService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SolicitudService implements ISolicitudService {

    private final ISolicitudRepository repository;
    private final SolicitudMapper mapper;

    @Override
    public SolicitudDto save(SolicitudCreateDto dto) {
        Solicitud solicitud = mapper.toEntity(dto);
        return mapper.toDto(repository.save(solicitud));
    }

    @Override
    public SolicitudDto findById(Integer id) {
        Solicitud solicitud = repository.findById(id).orElseThrow(() -> new ResourceNotFound("Solicitud no encontrada"));
        return mapper.toDto(solicitud);
    }

    @Override
    public List<SolicitudDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public SolicitudDto update(SolicitudDto dto) {
        Solicitud solicitud = repository.findById(dto.idSolicitud()).orElseThrow(() -> new ResourceNotFound("Solicitud no encontrada"));
        mapper.updateEntity(dto, solicitud);
        return mapper.toDto(repository.save(solicitud));
    }

    @Override
    public void deleteById(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFound("Solicitud no encontrada");
        }
        repository.deleteById(id);
    }

    @Override
    public List<SolicitudDto> findByIdOrIdCliente (Integer id,Integer idCliente) {
        return repository.findByIdSolicitudOrCliente_IdCliente(id,idCliente).stream().map(mapper::toDto).toList();
    }
}
