package com.pss.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pss.backend.domain.dto.mapper.MetodoPagoMapper;
import com.pss.backend.domain.dto.metodopago.MetodoPagoCreateDto;
import com.pss.backend.domain.dto.metodopago.MetodoPagoDto;
import com.pss.backend.domain.entity.MetodoPago;
import com.pss.backend.exceptions.ResourceDuplicate;
import com.pss.backend.exceptions.ResourceNotFound;
import com.pss.backend.repository.IMetodoPagoRepository;
import com.pss.backend.services.IServices.IMetodoPagoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MetodoPagoService implements IMetodoPagoService {

    private final IMetodoPagoRepository repository;
    private final MetodoPagoMapper mapper;


    @Override
    public MetodoPagoDto save(MetodoPagoCreateDto dto)
    {
        if(repository.existsByMetodoPago(dto.metodoPago())) throw new ResourceDuplicate("Ya existe este metodo de pago"); 
        
        MetodoPago metodoPago = mapper.toEntity(dto);

        return mapper.toDto(repository.save(metodoPago));
    }

    @Override
    public MetodoPagoDto findById(Integer id)
    {
        MetodoPago metodoPago = repository.findById(id).orElseThrow(() -> new ResourceNotFound("Metodo de pago no encontrado"));

        return mapper.toDto(metodoPago);
    
    }
    
    @Override
    public List<MetodoPagoDto> findAll()
    {
        List<MetodoPago> metodoPagoList = repository.findAll();
        
        List<MetodoPagoDto> metodoPagoDtos = metodoPagoList.stream().map(mapper::toDto).toList();

        return metodoPagoDtos;
    }
    
    @Override
    public MetodoPagoDto update(MetodoPagoDto dto)
    {
        MetodoPago metodoPago = repository.findById(dto.idMetodoPago()).orElseThrow(() -> new ResourceNotFound("Metodo de pago no encontrado"));

        mapper.updateEntity(dto, metodoPago);

        return mapper.toDto(repository.save(metodoPago));

        
    }
    
    @Override
    public void deleteById(Integer id)
    {
        if(!repository.existsById(id)) throw new ResourceNotFound("Metodo de pago no encontrado");

        repository.deleteById(id);
    }

}
