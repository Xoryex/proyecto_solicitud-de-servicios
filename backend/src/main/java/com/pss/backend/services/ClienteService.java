package com.pss.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pss.backend.domain.dto.cliente.ClienteCreateDto;
import com.pss.backend.domain.dto.cliente.ClienteDto;
import com.pss.backend.domain.dto.mapper.ClienteMapper;
import com.pss.backend.domain.entity.Cliente;
import com.pss.backend.exceptions.ResourceDuplicate;
import com.pss.backend.exceptions.ResourceNotFound;
import com.pss.backend.repository.IClienteRepository;
import com.pss.backend.services.IServices.IClienteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService implements IClienteService {

    private final IClienteRepository repository;
    private final ClienteMapper mapper;

    @Override
    public ClienteDto save (ClienteCreateDto dto) {    
        if(repository.existsByDocumentoCliente(dto.documentoCliente())) throw new ResourceDuplicate("Cliente ya esta registrado");

        var cliente = mapper.toEntity(dto);
    
        return mapper.toDto(repository.save(cliente)); 
    }
    @Override
    public ClienteDto findById(Integer id) {
        Cliente cliente = repository.findById(id).orElseThrow(() -> new ResourceNotFound("Cliente no encontrado"));
        return mapper.toDto(cliente);
    }

    @Override
    public List<ClienteDto> findAll(){
        List<Cliente> clientes = repository.findAll();

        return clientes.stream().map(mapper::toDto).toList();
    }

    @Override
    public ClienteDto update(ClienteDto dto) {
        
        if(repository.countByIdClienteOrDocumentoCliente(dto.idCliente(), dto.documentoCliente())>1) throw new ResourceDuplicate("Cliente ya esta registrado");

        Cliente cliente = repository.findById(dto.idCliente()).orElseThrow(() -> new ResourceNotFound("Cliente no encontrado"));        

        mapper.updateEntity(dto, cliente);
        return mapper.toDto(repository.save(cliente));
    }

    @Override
    public void deleteById(Integer id) {
        if(!repository.existsById(id)) throw new ResourceNotFound("No existe el cliente");
        repository.deleteById(id);
    }

}
