package com.pss.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pss.backend.domain.dto.rolDto;
import com.pss.backend.domain.dto.Mapper.RolMapper;
import com.pss.backend.domain.entity.roles;
import com.pss.backend.exception.ResourceDuplicate;
import com.pss.backend.exception.ResourceNotFound;
import com.pss.backend.repository.IRolRepository;
import com.pss.backend.service.IService.IRolService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RolService implements IRolService {

    private final IRolRepository rolRepository;
    private final RolMapper rolMapper;

    @Override
    public rolDto.response save(rolDto.create dto){
        
        if(rolRepository.existsByRol(dto.rol()))
            throw new ResourceDuplicate("El rol ya existe");

        roles rol = rolMapper.toEntity(dto);
        
        return rolMapper.toDTO(rolRepository.save(rol));
    }
    @Override
    public rolDto.response findById(Integer id){
        
        roles rol = rolRepository.findById(id).orElseThrow( () -> new ResourceNotFound("Rol no encontrado con id: " + id));

        return rolMapper.toDTO(rol);
    }
    @Override
    public List<rolDto.response> findAll(){

        List<roles> rolesList = rolRepository.findAll();

        List<rolDto.response> rolDtos = rolesList.stream()
                .map(rolMapper::toDTO)
                .toList();

        return rolDtos;
    }
    @Override
    public rolDto.response update(rolDto.update dto){

        roles rol = rolRepository.findById(dto.id()).orElseThrow(() -> new ResourceNotFound("Rol no encontrado"));

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
