package com.pss.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pss.backend.domain.dto.mapper.PermisoIdMapper;
import com.pss.backend.domain.dto.mapper.PermisoMapper;
import com.pss.backend.domain.dto.permiso.PermisoCreateDto;
import com.pss.backend.domain.dto.permiso.PermisoIdDto;
import com.pss.backend.domain.dto.permiso.PermisoUpdateDto;
import com.pss.backend.domain.dto.permiso.PermisoResponseDto;
import com.pss.backend.domain.entity.Permisos;
import com.pss.backend.domain.entity.PermisosId;
import com.pss.backend.exceptions.ResourceNotFound;
import com.pss.backend.repository.IPermisoRepository;
import com.pss.backend.services.IServices.IPermisoService;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class PermisoService implements IPermisoService {

    @Autowired
    private IPermisoRepository permisoRepository;
    
    @Autowired
    private PermisoMapper permisoMapper;

    @Autowired
    private PermisoIdMapper permisoIdMapper;

    

    @Override
    public PermisoResponseDto save (PermisoCreateDto dto)
    {
        Permisos permiso = permisoMapper.toEntity(dto);
        permisoRepository.save(permiso);
        return permisoMapper.toDTO(permiso);
    }
    @Override
    public PermisoResponseDto findById(PermisoIdDto id){
        PermisosId permisoId = permisoIdMapper.toEntity(id);
        Permisos permiso = permisoRepository.findById(permisoId).orElseThrow(() -> new ResourceNotFound("Permiso no encontrado"));

        return permisoMapper.toDTO(permiso);
    }
    @Override
    public List<PermisoResponseDto> findAll(){
        List<Permisos> permisosList = permisoRepository.findAll();
        List<PermisoResponseDto> permisoDtos = permisosList.stream()
                .map(permisoMapper::toDTO)
                .toList();
        return permisoDtos;
    }
    @Override
    public PermisoResponseDto update(PermisoUpdateDto dto){
        
        Permisos permiso = permisoRepository.findById(permisoIdMapper.toEntity(dto.idPermiso())).orElseThrow(() -> new ResourceNotFound("Permiso no encontrado"));

        permisoMapper.updateEntity(dto, permiso);

        return permisoMapper.toDTO(permisoRepository.save(permiso));
    }
    @Override
    public void deleteById(PermisoIdDto id){
        
        PermisosId permisoId = permisoIdMapper.toEntity(id);
        
        if (!permisoRepository.existsById(permisoId)) {
            throw new ResourceNotFound("Permiso no encontrado");
        }
        permisoRepository.deleteById(permisoId);
    }

    @Override
    public List<PermisoResponseDto> findByModulosOrIdRol(PermisoIdDto id) {
        List<Permisos> permisosList = permisoRepository.findByIdPermiso_ModuloOrIdPermiso_IdRol(id.modulo(), id.idRol()).orElseThrow(() -> new ResourceNotFound("Permisos no encontrados"));
        List<PermisoResponseDto> permisoDtos = permisosList.stream()
                .map(permisoMapper::toDTO)
                .toList();
        return permisoDtos;
    }
}
