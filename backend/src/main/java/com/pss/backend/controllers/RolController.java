package com.pss.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pss.backend.domain.dto.rol.RolCreateDto;
import com.pss.backend.domain.dto.rol.RolDto;
import com.pss.backend.services.IServices.IRolService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/rol")
@RequiredArgsConstructor
public class RolController {
    
    private final IRolService rolService;
    
    @GetMapping()
    public ResponseEntity<?> getRol(@RequestParam(required = false, name = "id") Integer id) {
        if (id != null) 
            return ResponseEntity.ok(rolService.findById(id));
        
        return ResponseEntity.ok(rolService.findAll());
    }

    @PostMapping()
    public ResponseEntity<?> saveRol(@RequestBody RolCreateDto dto) {
        return ResponseEntity.ok(rolService.save(dto));
    }
    
    @PutMapping("/update")
    public ResponseEntity<?> updateRol(@RequestBody RolDto dto) {
        return ResponseEntity.ok(rolService.update(dto));
    }
    
    @DeleteMapping()
    public ResponseEntity<?> deleteRol(@RequestParam("id_delete") Integer id) {
        rolService.deleteById(id);
        return ResponseEntity.ok("Eliminado correctamente");
    }


}
