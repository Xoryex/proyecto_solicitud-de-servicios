package com.pss.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pss.backend.domain.dto.solicitud.SolicitudCreateDto;
import com.pss.backend.domain.dto.solicitud.SolicitudDto;
import com.pss.backend.services.IServices.ISolicitudService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/solicitud")
@RequiredArgsConstructor
public class SolicitudController {

    private final ISolicitudService service;

    @PostMapping
    public ResponseEntity<?> saveSolicitud(@RequestBody SolicitudCreateDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<?> getSolicitud(
            @RequestParam(required = false, name = "id") Integer id,
            @RequestParam(required = false, name = "id_cliente") Integer idCliente) {
        if (id != null || idCliente != null) {
            return ResponseEntity.ok(service.findByIdOrIdCliente(id, idCliente));
        }
        
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping
    public ResponseEntity<?> updateSolicitud(@RequestBody SolicitudDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteSolicitud(@RequestParam("id_delete") Integer id) {
        service.deleteById(id);
        return ResponseEntity.ok("Solicitud eliminada correctamente");
    }
}
