package com.pss.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pss.backend.domain.dto.horario.HorarioDto;
import com.pss.backend.domain.dto.horario.IdHorarioDto;
import com.pss.backend.services.IServices.IHorarioService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/horario")
@RequiredArgsConstructor
public class HorarioController {

    private final IHorarioService service;

    @PostMapping
    public ResponseEntity<?> saveHorario(@RequestBody HorarioDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<?> getHorario(
            @RequestParam(required = false, name = "dia") String dia,
            @RequestParam(required = false, name = "id_proveedor") Integer idProveedor) {
        if (dia != null || idProveedor != null) {
            return ResponseEntity.ok(service.findByDiaOrIdProveedor(dia,idProveedor));
        }
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping
    public ResponseEntity<?> updateHorario(@RequestBody HorarioDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteHorario(
            @RequestParam("dia") String dia,
            @RequestParam("id_proveedor") Integer idProveedor) {
        service.deleteById(new IdHorarioDto(dia, idProveedor));
        return ResponseEntity.ok("Horario eliminado correctamente");
    }
}
