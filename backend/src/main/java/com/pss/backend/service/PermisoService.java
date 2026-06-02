package com.pss.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pss.backend.domain.dto.permisoDto;
import com.pss.backend.domain.dto.Mapper.PermisoIdMapper;
import com.pss.backend.domain.dto.Mapper.PermisoMapper;
import com.pss.backend.domain.entity.permisos;
import com.pss.backend.domain.entity.permisosId;
import com.pss.backend.exception.ResourceNotFound;
import com.pss.backend.repository.IPermisoRepository;
import com.pss.backend.service.IService.IPermisoService;


@Service
public class PermisoService implements IPermisoService {

    @Autowired
    private IPermisoRepository permisoRepository;

    @Autowired
    private PermisoMapper permisoMapper;

    @Autowired
    private PermisoIdMapper permisoIdMapper;

    

    @Override
    public permisoDto.response save (permisoDto.create dto)
    {
        permisos permiso = permisoMapper.toEntity(dto);
        permisoRepository.save(permiso);
        return permisoMapper.toDTO(permiso);
    }
    @Override
    public permisoDto.response findById(permisoDto.id id){
        permisosId permisoId = permisoIdMapper.toEntity(id);
        permisos permiso = permisoRepository.findById(permisoId).orElseThrow(() -> new ResourceNotFound("Permiso no encontrado"));

        return permisoMapper.toDTO(permiso);
    }
    @Override
    public List<permisoDto.response> findAll(){
        List<permisos> permisosList = permisoRepository.findAll();
        List<permisoDto.response> permisoDtos = permisosList.stream()
                .map(permisoMapper::toDTO)
                .toList();
        return permisoDtos;
    }
    @Override
    public permisoDto.response update(permisoDto.update dto){
        
        permisos permiso = permisoRepository.findById(permisoIdMapper.toEntity(dto.id())).orElseThrow(() -> new ResourceNotFound("Permiso no encontrado"));

        permisoMapper.updateEntity(dto, permiso);

        return permisoMapper.toDTO(permisoRepository.save(permiso));
    }
    @Override
    public void deleteById(permisoDto.id id){
        
        permisosId permisoId = permisoIdMapper.toEntity(id);
        
        if (!permisoRepository.existsById(permisoId)) {
            throw new ResourceNotFound("Permiso no encontrado");
        }
        permisoRepository.deleteById(permisoId);
    }

    @Override
    public List<permisoDto.response> findByModulosOrIdRol(permisoDto.id id) {
        List<permisos> permisosList = permisoRepository.findByIdModuloOrIdIdRol(id.modulo(), id.idRol()).orElseThrow(() -> new ResourceNotFound("Permisos no encontrados"));
        List<permisoDto.response> permisoDtos = permisosList.stream()
                .map(permisoMapper::toDTO)
                .toList();
        return permisoDtos;
    }
}
