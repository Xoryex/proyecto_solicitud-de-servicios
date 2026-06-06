package com.pss.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pss.backend.domain.dto.servicio.ServicioCreateDto;
import com.pss.backend.domain.dto.servicio.ServicioDto;
import com.pss.backend.services.IServices.IServicioService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/servicio")
@RequiredArgsConstructor
public class ServicioController {

    private final IServicioService service;

    @PostMapping
    public ResponseEntity<?> saveServicio(@RequestBody ServicioCreateDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<?> getServicio(
            @RequestParam(required = false, name = "id") Integer id,
            @RequestParam(required = false, name = "id_proveedor") Integer idProveedor,
            @RequestParam(required = false, name = "id_tipo_servicio") Integer idTipoServicio) {
        if (id != null || idProveedor != null || idTipoServicio != null) {
            return ResponseEntity.ok(service.findByIdOrProveedorOrTipoServicio(id, idProveedor, idTipoServicio));
        }
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping
    public ResponseEntity<?> updateServicio(@RequestBody ServicioDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteServicio(@RequestParam("id_delete") Integer id) {
        service.deleteById(id);
        return ResponseEntity.ok("Servicio eliminado correctamente");
    }
}
