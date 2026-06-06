package com.pss.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pss.backend.domain.dto.permiso.IdPermisoDto;
import com.pss.backend.domain.dto.permiso.PermisoDto;
import com.pss.backend.services.IServices.IPermisoService;

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
    public ResponseEntity<?> getPermiso(@RequestParam(required = false,name = "idRol") Integer idRol, @RequestParam(required = false, name = "modulo") String modulo) {

        if (idRol != null && modulo != null) 
            return ResponseEntity.ok(permisoService.findById(new IdPermisoDto(modulo, idRol)));
        if (idRol != null || modulo != null) 
            return ResponseEntity.ok(permisoService.findByModulosOrIdRol(new IdPermisoDto(modulo, idRol)));
     
        return ResponseEntity.ok(permisoService.findAll());
    }

    @PostMapping()
    public ResponseEntity<?> savePermiso(@RequestBody PermisoDto dto) {
        return ResponseEntity.ok(permisoService.save(dto));
    }
    
    @PutMapping("/update")
    public ResponseEntity<?> updatePermiso(@RequestBody PermisoDto dto) {        
        return ResponseEntity.ok(permisoService.update(dto));
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<?> deletePermiso(@RequestBody IdPermisoDto id) {

        permisoService.deleteById(id);
        return ResponseEntity.ok("Eliminado correctamente");
    }

}
