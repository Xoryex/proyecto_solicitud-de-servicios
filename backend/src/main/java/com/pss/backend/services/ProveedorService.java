package com.pss.backend.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.pss.backend.domain.dto.proveedor.ProveedorCreateDto;
import com.pss.backend.domain.dto.proveedor.ProveedorDto;
import com.pss.backend.domain.dto.mapper.ProveedorMapper;
import com.pss.backend.domain.entity.Proveedor;
import com.pss.backend.exceptions.ResourceDuplicate;
import com.pss.backend.exceptions.ResourceNotFound;
import com.pss.backend.repository.IProveedorRepository;
import com.pss.backend.services.IServices.IProveedorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorService implements IProveedorService {

    private final IProveedorRepository repository;
    private final ProveedorMapper mapper;

    @Override
    public ProveedorDto save(ProveedorCreateDto dto) {
        if (repository.existsByDocumentoProveedor(dto.documentoProveedor())) {
            throw new ResourceDuplicate("El proveedor ya está registrado");
        }
        Proveedor proveedor = mapper.toEntity(dto);
        return mapper.toDto(repository.save(proveedor));
    }

    @Override
    public ProveedorDto findById(Integer id) {
        Proveedor proveedor = repository.findById(id).orElseThrow(() -> new ResourceNotFound("Proveedor no encontrado"));
        return mapper.toDto(proveedor);
    }

    @Override
    public List<ProveedorDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public ProveedorDto update(ProveedorDto dto) {
        if (repository.countByIdProveedorOrDocumentoProveedor(dto.idProveedor(), dto.documentoProveedor()) > 1) {
            throw new ResourceDuplicate("El proveedor ya está registrado");
        }
        Proveedor proveedor = repository.findById(dto.idProveedor()).orElseThrow(() -> new ResourceNotFound("Proveedor no encontrado"));
        mapper.updateEntity(dto, proveedor);
        return mapper.toDto(repository.save(proveedor));
    }

    @Override
    public void deleteById(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFound("Proveedor no encontrado");
        }
        repository.deleteById(id);
    }
}
