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

import com.pss.backend.domain.dto.usuario.UsuarioCreateDto;
import com.pss.backend.domain.dto.usuario.UsuarioDto;
import com.pss.backend.services.IServices.IUsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final IUsuarioService usuarioService;

    @PostMapping()
    public ResponseEntity<?> saveUsuario(@RequestBody UsuarioCreateDto dto) {
        return ResponseEntity.ok(usuarioService.save(dto));
    }

    @GetMapping()
    public ResponseEntity<?> getUsuario(@RequestParam(required = false, name = "id") Integer id) {
        
        if(id != null ) return ResponseEntity.ok(usuarioService.findById(id));

        return ResponseEntity.ok(usuarioService.findAll());
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody UsuarioDto dto) {
        return ResponseEntity.ok(usuarioService.update(dto));
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteById(@RequestParam(name="id_delete") Integer id) {
        usuarioService.deleteById(id);
        return ResponseEntity.ok("Eliminacion exitosa");
    }

}
