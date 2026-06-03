package com.pss.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pss.backend.domain.dto.permiso.PermisoCreateDto;
import com.pss.backend.domain.dto.permiso.PermisoIdDto;
import com.pss.backend.domain.dto.permiso.PermisoUpdateDto;
import com.pss.backend.services.IServices.IPermisoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/permiso")
public class PermisoController {

    @Autowired
    private IPermisoService permisoService;


    @GetMapping()
    public ResponseEntity<?> getPermiso(@RequestParam(required = false,name = "idRol") Integer idRol, @RequestParam(required = false, name = "modulo") String modulo) {

        if (idRol != null && modulo != null) 
            return ResponseEntity.ok(permisoService.findById(new PermisoIdDto(modulo, idRol)));
        if (idRol != null || modulo != null) 
            return ResponseEntity.ok(permisoService.findByModulosOrIdRol(new PermisoIdDto(modulo, idRol)));
     
        return ResponseEntity.ok(permisoService.findAll());
    }

    @PostMapping()
    public ResponseEntity<?> savePermiso(@RequestBody PermisoCreateDto dto) {
        return ResponseEntity.ok(permisoService.save(dto));
    }
    
    @PutMapping("/update")
    public ResponseEntity<?> updatePermiso(@RequestBody PermisoUpdateDto dto) {        
        return ResponseEntity.ok(permisoService.update(dto));
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<?> deletePermiso(@RequestBody PermisoIdDto id) {

        permisoService.deleteById(id);
        return ResponseEntity.ok("Eliminado correctamente");
    }

}
