package com.pss.backend.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.pss.backend.domain.dto.serviciometodopago.ServicioMetodoPagoDto;
import com.pss.backend.domain.dto.serviciometodopago.IdServicioMetodoPagoDto;
import com.pss.backend.domain.dto.mapper.ServicioMetodoPagoMapper;
import com.pss.backend.domain.dto.mapper.IdServicioMetodoPagoMapper;
import com.pss.backend.domain.entity.ServicioMetodoPago;
import com.pss.backend.domain.entity.IdServicioMetodoPago;
import com.pss.backend.exceptions.ResourceDuplicate;
import com.pss.backend.exceptions.ResourceNotFound;
import com.pss.backend.repository.IServicioMetodoPagoRepository;
import com.pss.backend.services.IServices.IServicioMetodoPagoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioMetodoPagoService implements IServicioMetodoPagoService {

    private final IServicioMetodoPagoRepository repository;
    private final ServicioMetodoPagoMapper mapper;
    private final IdServicioMetodoPagoMapper idMapper;

    @Override
    public ServicioMetodoPagoDto save(ServicioMetodoPagoDto dto) {
        IdServicioMetodoPago id = idMapper.toEntity(dto.idServicioMetodoPago());
        if (repository.existsById(id)) {
            throw new ResourceDuplicate("La relación servicio - método de pago ya existe");
        }
        ServicioMetodoPago entity = mapper.toEntity(dto);
        entity.setIdServicioMetodoPago(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public ServicioMetodoPagoDto findById(IdServicioMetodoPagoDto idDto) {
        IdServicioMetodoPago id = idMapper.toEntity(idDto);
        ServicioMetodoPago entity = repository.findById(id).orElseThrow(() -> new ResourceNotFound("Relación servicio - método de pago no encontrada"));
        return mapper.toDto(entity);
    }

    @Override
    public List<ServicioMetodoPagoDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public ServicioMetodoPagoDto update(ServicioMetodoPagoDto dto) {
        IdServicioMetodoPago id = idMapper.toEntity(dto.idServicioMetodoPago());
        ServicioMetodoPago entity = repository.findById(id).orElseThrow(() -> new ResourceNotFound("Relación servicio - método de pago no encontrada"));
        mapper.updateEntity(dto, entity);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deleteById(IdServicioMetodoPagoDto idDto) {
        IdServicioMetodoPago id = idMapper.toEntity(idDto);
        if (!repository.existsById(id)) {
            throw new ResourceNotFound("Relación servicio - método de pago no encontrada");
        }
        repository.deleteById(id);
    }

    @Override
    public List<ServicioMetodoPagoDto> findByIdServicioOrIdServicio(Integer idServicio,Integer idMetodoPago)
    {
        List<ServicioMetodoPago> serviciosMetodosPago = repository.findByIdServicioMetodoPago_IdServicioOrIdServicioMetodoPago_IdServicio(idServicio, idMetodoPago);
        return serviciosMetodosPago.stream().map(mapper::toDto).toList();
    }
}
