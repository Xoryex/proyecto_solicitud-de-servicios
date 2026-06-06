package com.pss.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pss.backend.domain.dto.metodopago.MetodoPagoCreateDto;
import com.pss.backend.domain.dto.metodopago.MetodoPagoDto;
import com.pss.backend.services.IServices.IMetodoPagoService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/metodo_pago")
@RequiredArgsConstructor
public class MetodoPagoController {

    private final IMetodoPagoService service;

    @GetMapping
    public ResponseEntity<?> getMetodPago(@RequestParam(required = false, name = "id") Integer id) {
        if(id != null) return ResponseEntity.ok(service.findById(id));

        return ResponseEntity.ok(service.findAll());

    }
    @PostMapping
    public ResponseEntity<?> postMetodoPago(@RequestBody MetodoPagoCreateDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }
    @PutMapping
    public ResponseEntity<?> putMetodoPago(@RequestBody MetodoPagoDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }
    @DeleteMapping()
    public ResponseEntity<?> deleteMetodoPago(@RequestParam("id_delete") Integer id) {
        
        service.deleteById(id);

        return ResponseEntity.ok("Eliminado correctamente");
    }
    
    

}
