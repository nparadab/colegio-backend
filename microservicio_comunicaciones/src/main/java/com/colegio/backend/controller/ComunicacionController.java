package com.colegio.backend.controller;

import com.colegio.backend.dto.MensajeRequest;
import com.colegio.backend.dto.MensajeResponse;
import com.colegio.backend.service.ComunicacionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comunicaciones")
public class ComunicacionController {

    private final ComunicacionService service;

    public ComunicacionController(ComunicacionService service) {
        this.service = service;
    }

    @PostMapping("/enviar")
    public ResponseEntity<MensajeResponse> enviar(@Valid @RequestBody MensajeRequest request) {
        MensajeResponse response = service.enviarMensaje(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
