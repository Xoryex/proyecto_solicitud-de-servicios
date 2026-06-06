package com.pss.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pss.backend.domain.dto.cliente.ClienteCreateDto;
import com.pss.backend.domain.dto.cliente.ClienteDto;
import com.pss.backend.services.IServices.IClienteService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final IClienteService service;

    @PostMapping
    public ResponseEntity<?> saveCliente(@RequestBody ClienteCreateDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<?> getCliente(@RequestParam(required = false, name = "id") Integer id) {
        if (id != null) 
            return ResponseEntity.ok(service.findById(id));

        return ResponseEntity.ok(service.findAll());
    }
    
    @PutMapping
    public ResponseEntity<?> updateCliente(@RequestBody ClienteDto dto)
    {
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCliente(@RequestParam("id_delete") Integer id)
    {
        service.deleteById(id);
        return ResponseEntity.ok("Cliente se elimino correctamente");
    }


}
