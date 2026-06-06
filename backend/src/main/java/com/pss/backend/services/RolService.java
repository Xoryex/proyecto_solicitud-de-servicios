package com.pss.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pss.backend.domain.dto.mapper.RolMapper;
import com.pss.backend.domain.dto.rol.RolCreateDto;
import com.pss.backend.domain.dto.rol.RolDto;
import com.pss.backend.domain.entity.Rol;
import com.pss.backend.exceptions.ResourceDuplicate;
import com.pss.backend.exceptions.ResourceNotFound;
import com.pss.backend.repository.IRolRepository;
import com.pss.backend.services.IServices.IRolService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class RolService implements IRolService {

    private final IRolRepository rolRepository;
    private final RolMapper rolMapper;

    @Override
    public RolDto save(RolCreateDto dto){
        
        if(rolRepository.existsByRol(dto.rol()))
            throw new ResourceDuplicate("El rol ya existe");

        Rol rol = rolMapper.toEntity(dto);
        
        return rolMapper.toDTO(rolRepository.save(rol));
    }
    @Override
    public RolDto findById(Integer id){
        
        Rol rol = rolRepository.findById(id).orElseThrow( () -> new ResourceNotFound("Rol no encontrado con id: " + id));

        return rolMapper.toDTO(rol);
    }
    @Override
    public List<RolDto> findAll(){

        List<Rol> rolesList = rolRepository.findAll();

        List<RolDto> rolDtos = rolesList.stream()
                .map(rolMapper::toDTO)
                .toList();

        return rolDtos;
    }
    @Override
    public RolDto update(RolDto dto){

        Rol rol = rolRepository.findById(dto.idRol()).orElseThrow(() -> new ResourceNotFound("Rol no encontrado"));

        if(rolRepository.existsByRol(dto.rol()))
            throw new ResourceDuplicate("El rol ya existe");

        rolMapper.updateEntity(dto, rol);

        return rolMapper.toDTO(rolRepository.save(rol));
    }
    @Override
    public void deleteById(Integer id){
        if(!rolRepository.existsById(id))
            throw new ResourceNotFound("Rol no encontrado con id: " + id);
        
        rolRepository.deleteById(id);
    }

}
