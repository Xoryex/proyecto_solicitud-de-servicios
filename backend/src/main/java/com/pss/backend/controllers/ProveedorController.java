package com.pss.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pss.backend.domain.dto.proveedor.ProveedorCreateDto;
import com.pss.backend.domain.dto.proveedor.ProveedorDto;
import com.pss.backend.services.IServices.IProveedorService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/proveedor")
@RequiredArgsConstructor
public class ProveedorController {

    private final IProveedorService service;

    @PostMapping
    public ResponseEntity<?> saveProveedor(@RequestBody ProveedorCreateDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<?> getProveedor(@RequestParam(required = false, name = "id") Integer id) {
        if (id != null) {
            return ResponseEntity.ok(service.findById(id));
        }
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping
    public ResponseEntity<?> updateProveedor(@RequestBody ProveedorDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteProveedor(@RequestParam("id_delete") Integer id) {
        service.deleteById(id);
        return ResponseEntity.ok("Proveedor eliminado correctamente");
    }
}
