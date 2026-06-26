package com.colegio.backend.controller;

import com.colegio.backend.dto.AsistenciaDTO;
import com.colegio.backend.service.AsistenciaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RestController
@RequestMapping("/api/asistencia")
public class AsistenciaController {

    private final AsistenciaService asistenciaService;

    public AsistenciaController(AsistenciaService asistenciaService) {
        this.asistenciaService = asistenciaService;
    }

    @GetMapping("/alumno/{alumnoId}")
    public ResponseEntity<AsistenciaDTO> obtenerAsistencia(@PathVariable Long alumnoId) {
        try {
            return asistenciaService.obtenerPorAlumnoId(alumnoId)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/alumno/{alumnoId}/historial")
    public ResponseEntity<List<AsistenciaDTO>> listarHistorial(@PathVariable Long alumnoId) {
        try {
            return ResponseEntity.ok(asistenciaService.listarPorAlumnoId(alumnoId));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<AsistenciaDTO> guardar(@Valid @RequestBody AsistenciaDTO dto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(asistenciaService.guardar(dto));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}
