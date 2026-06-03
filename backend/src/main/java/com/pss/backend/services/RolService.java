package com.pss.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pss.backend.domain.dto.mapper.RolMapper;
import com.pss.backend.domain.dto.rol.RolCreateDto;
import com.pss.backend.domain.dto.rol.RolUpdateDto;
import com.pss.backend.domain.dto.rol.RolResponseDto;
import com.pss.backend.domain.entity.Roles;
import com.pss.backend.exceptions.ResourceDuplicate;
import com.pss.backend.exceptions.ResourceNotFound;
import com.pss.backend.repository.IRolRepository;
import com.pss.backend.services.IServices.IRolService;


@Service
public class RolService implements IRolService {

    @Autowired
    private IRolRepository rolRepository;
    @Autowired
    private RolMapper rolMapper;

    @Override
    public RolResponseDto save(RolCreateDto dto){
        
        if(rolRepository.existsByRol(dto.rol()))
            throw new ResourceDuplicate("El rol ya existe");

        Roles rol = rolMapper.toEntity(dto);
        
        return rolMapper.toDTO(rolRepository.save(rol));
    }
    @Override
    public RolResponseDto findById(Integer id){
        
        Roles rol = rolRepository.findById(id).orElseThrow( () -> new ResourceNotFound("Rol no encontrado con id: " + id));

        return rolMapper.toDTO(rol);
    }
    @Override
    public List<RolResponseDto> findAll(){

        List<Roles> rolesList = rolRepository.findAll();

        List<RolResponseDto> rolDtos = rolesList.stream()
                .map(rolMapper::toDTO)
                .toList();

        return rolDtos;
    }
    @Override
    public RolResponseDto update(RolUpdateDto dto){

        Roles rol = rolRepository.findById(dto.idRol()).orElseThrow(() -> new ResourceNotFound("Rol no encontrado"));

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

    // @Override
    // public List<rolDto> filter(rolDto dto){

    //     roles rol = rolMapper.toEntity(dto);


    // }

}
