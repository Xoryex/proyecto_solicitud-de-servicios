package com.pss.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pss.backend.domain.dto.permisoDto;
import com.pss.backend.service.IService.IPermisoService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/permiso")
@RequiredArgsConstructor
public class PermisoController {

    private final IPermisoService permisoService;


    @GetMapping()
    public ResponseEntity<?> getPermiso(@RequestParam("idRol") Integer idRol, @RequestParam("modulo") String modulo) {
        if (idRol != null && modulo != null) 
            return ResponseEntity.ok(permisoService.findById(new permisoDto.id(modulo, idRol)));
        if (idRol != null || modulo != null) 
            return ResponseEntity.ok(permisoService.findByModulosOrIdRol(new permisoDto.id(modulo, idRol)));
     
   

        return ResponseEntity.ok(permisoService.findAll());
    }

    @PostMapping()
    public ResponseEntity<?> savePermiso(@RequestBody permisoDto.create dto) {
        return ResponseEntity.ok(permisoService.save(dto));
    }
    
    @PutMapping("/update")
    public ResponseEntity<?> updatePermiso(@RequestBody permisoDto.update dto) {        
        return ResponseEntity.ok(permisoService.update(dto));
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<?> deletePermiso(@RequestBody permisoDto.id id) {

        permisoService.deleteById(id);
        return ResponseEntity.ok("Eliminado correctamente");
    }

}
