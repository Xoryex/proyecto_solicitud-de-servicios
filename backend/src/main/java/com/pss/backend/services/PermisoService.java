package com.pss.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pss.backend.domain.dto.mapper.IdPermisoMapper;
import com.pss.backend.domain.dto.mapper.PermisoMapper;
import com.pss.backend.domain.dto.permiso.IdPermisoDto;
import com.pss.backend.domain.dto.permiso.PermisoDto;
import com.pss.backend.domain.entity.Permiso;
import com.pss.backend.domain.entity.IdPermiso;
import com.pss.backend.exceptions.ResourceDuplicate;
import com.pss.backend.exceptions.ResourceNotFound;
import com.pss.backend.repository.IPermisoRepository;
import com.pss.backend.services.IServices.IPermisoService;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class PermisoService implements IPermisoService {

    
    private final IPermisoRepository permisoRepository;
    private final PermisoMapper permisoMapper;
    private final IdPermisoMapper permisoIdMapper;

    

    @Override
    public PermisoDto save (PermisoDto dto)
    {
        Permiso permiso = permisoMapper.toEntity(dto);
        if(permisoRepository.existsById(permiso.getIdPermiso())) throw new ResourceDuplicate("El permiso ya existe");
        permisoRepository.save(permiso);
        return permisoMapper.toDTO(permiso);
    }
    @Override
    public PermisoDto findById(IdPermisoDto id){
        IdPermiso permisoId = permisoIdMapper.toEntity(id);
        Permiso permiso = permisoRepository.findById(permisoId).orElseThrow(() -> new ResourceNotFound("Permiso no encontrado"));

        return permisoMapper.toDTO(permiso);
    }
    @Override
    public List<PermisoDto> findAll(){
        List<Permiso> permisosList = permisoRepository.findAll();
        List<PermisoDto> permisoDtos = permisosList.stream()
                .map(permisoMapper::toDTO)
                .toList();
        return permisoDtos;
    }
    @Override
    public PermisoDto update(PermisoDto dto){
        
        Permiso permiso = permisoRepository.findById(permisoIdMapper.toEntity(dto.idPermiso())).orElseThrow(() -> new ResourceNotFound("Permiso no encontrado"));

        permisoMapper.updateEntity(dto, permiso);

        return permisoMapper.toDTO(permisoRepository.save(permiso));
    }
    @Override
    public void deleteById(IdPermisoDto id){
        
        IdPermiso permisoId = permisoIdMapper.toEntity(id);
        
        if (!permisoRepository.existsById(permisoId)) {
            throw new ResourceNotFound("Permiso no encontrado");
        }
        permisoRepository.deleteById(permisoId);
    }

    @Override
    public List<PermisoDto> findByModulosOrIdRol(IdPermisoDto id) {
        List<Permiso> permisosList = permisoRepository.findByIdPermiso_ModuloOrIdPermiso_IdRol(id.modulo(), id.idRol()).orElseThrow(() -> new ResourceNotFound("Permisos no encontrados"));
        List<PermisoDto> permisoDtos = permisosList.stream()
                .map(permisoMapper::toDTO)
                .toList();
        return permisoDtos;
    }
}
