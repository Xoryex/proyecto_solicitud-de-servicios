package com.pss.backend.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.pss.backend.domain.dto.tiposervicio.TipoServicioCreateDto;
import com.pss.backend.domain.dto.tiposervicio.TipoServicioDto;
import com.pss.backend.domain.dto.mapper.TipoServicioMapper;
import com.pss.backend.domain.entity.TipoServicio;
import com.pss.backend.exceptions.ResourceDuplicate;
import com.pss.backend.exceptions.ResourceNotFound;
import com.pss.backend.repository.ITipoServicioRepository;
import com.pss.backend.services.IServices.ITipoServicioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoServicioService implements ITipoServicioService {

    private final ITipoServicioRepository repository;
    private final TipoServicioMapper mapper;

    @Override
    public TipoServicioDto save(TipoServicioCreateDto dto) {
        if (repository.existsByTipoServicio(dto.tipoServicio())) {
            throw new ResourceDuplicate("El tipo de servicio ya existe");
        }
        TipoServicio tipo = mapper.toEntity(dto);
        return mapper.toDto(repository.save(tipo));
    }

    @Override
    public TipoServicioDto findById(Integer id) {
        TipoServicio tipo = repository.findById(id).orElseThrow(() -> new ResourceNotFound("Tipo de servicio no encontrado"));
        return mapper.toDto(tipo);
    }

    @Override
    public List<TipoServicioDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public TipoServicioDto update(TipoServicioDto dto) {
        if (repository.countByIdTipoServicioOrTipoServicio(dto.idTipoServicio(), dto.tipoServicio()) > 1) {
            throw new ResourceDuplicate("El tipo de servicio ya existe");
        }
        TipoServicio tipo = repository.findById(dto.idTipoServicio()).orElseThrow(() -> new ResourceNotFound("Tipo de servicio no encontrado"));
        mapper.updateEntity(dto, tipo);
        return mapper.toDto(repository.save(tipo));
    }

    @Override
    public void deleteById(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFound("Tipo de servicio no encontrado");
        }
        repository.deleteById(id);
    }
}
