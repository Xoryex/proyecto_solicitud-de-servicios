package com.pss.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pss.backend.domain.dto.serviciometodopago.ServicioMetodoPagoDto;
import com.pss.backend.domain.dto.serviciometodopago.IdServicioMetodoPagoDto;
import com.pss.backend.services.IServices.IServicioMetodoPagoService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/servicio_metodo_pago")
@RequiredArgsConstructor
public class ServicioMetodoPagoController {

    private final IServicioMetodoPagoService service;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ServicioMetodoPagoDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<?> get(
            @RequestParam(required = false, name = "id_servicio") Integer idServicio,
            @RequestParam(required = false, name = "id_metodo_pago") Integer idMetodoPago) {
                
        if (idServicio != null || idMetodoPago != null) return ResponseEntity.ok(service.findByIdServicioOrIdServicio(idServicio, idMetodoPago));
        
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ServicioMetodoPagoDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(
            @RequestParam("id_servicio") Integer idServicio,
            @RequestParam("id_metodo_pago") Integer idMetodoPago) {
        service.deleteById(new IdServicioMetodoPagoDto(idServicio, idMetodoPago));
        return ResponseEntity.ok("Relación servicio - método de pago eliminada correctamente");
    }
}
