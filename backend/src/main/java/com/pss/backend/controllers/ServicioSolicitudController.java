package com.pss.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pss.backend.domain.dto.serviciosolicitud.ServicioSolicitudDto;
import com.pss.backend.domain.dto.serviciosolicitud.IdServicioSolicitudDto;
import com.pss.backend.services.IServices.IServicioSolicitudService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/servicio_solicitud")
@RequiredArgsConstructor
public class ServicioSolicitudController {

    private final IServicioSolicitudService service;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ServicioSolicitudDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<?> get(
            @RequestParam(required = false, name = "id_servicio") Integer idServicio,
            @RequestParam(required = false, name = "id_solicitud") Integer idSolicitud) {
        if (idServicio != null || idSolicitud != null) {
            return ResponseEntity.ok(service.findByIdServicioOrIdSolicitud(idServicio, idSolicitud));
        }
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ServicioSolicitudDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(
            @RequestParam("id_servicio") Integer idServicio,
            @RequestParam("id_solicitud") Integer idSolicitud) {
        service.deleteById(new IdServicioSolicitudDto(idServicio, idSolicitud));
        return ResponseEntity.ok("Relación servicio - solicitud eliminada correctamente");
    }
}
