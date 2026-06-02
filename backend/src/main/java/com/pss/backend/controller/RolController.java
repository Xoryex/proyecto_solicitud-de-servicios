package com.pss.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pss.backend.domain.dto.rolDto;
import com.pss.backend.service.RolService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/rol")
public class RolController {
    @Autowired
    private RolService rolService;
    
    @GetMapping()
    public ResponseEntity<?> getRol(@PathParam("id") Integer id) {
        if (id != null) 
            return ResponseEntity.ok(rolService.findById(id));
        
        return ResponseEntity.ok(rolService.findAll());
    }

    @PostMapping()
    public ResponseEntity<?> saveRol(@RequestBody rolDto.create dto) {
        return ResponseEntity.ok(rolService.save(dto));
    }
    
    @PutMapping("/update")
    public ResponseEntity<?> updateRol(@RequestBody rolDto.update dto) {
        return ResponseEntity.ok(rolService.update(dto));
    }
    
    @DeleteMapping()
    public ResponseEntity<?> deleteRol(@PathParam("id_delete") Integer id) {
        rolService.deleteById(id);
        return ResponseEntity.ok("Eliminado correctamente");
    }


}
