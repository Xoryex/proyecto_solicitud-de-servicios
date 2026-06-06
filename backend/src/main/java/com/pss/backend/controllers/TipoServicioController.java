package com.pss.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pss.backend.domain.dto.tiposervicio.TipoServicioCreateDto;
import com.pss.backend.domain.dto.tiposervicio.TipoServicioDto;
import com.pss.backend.services.IServices.ITipoServicioService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/tipo_servicio")
@RequiredArgsConstructor
public class TipoServicioController {

    private final ITipoServicioService service;

    @PostMapping
    public ResponseEntity<?> saveTipoServicio(@RequestBody TipoServicioCreateDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<?> getTipoServicio(@RequestParam(required = false, name = "id") Integer id) {
        if (id != null) {
            return ResponseEntity.ok(service.findById(id));
        }
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping
    public ResponseEntity<?> updateTipoServicio(@RequestBody TipoServicioDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteTipoServicio(@RequestParam("id_delete") Integer id) {
        service.deleteById(id);
        return ResponseEntity.ok("Tipo de servicio eliminado correctamente");
    }
}
