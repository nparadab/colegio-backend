package com.colegio.backend.controller;

import com.colegio.backend.dto.NotaCalculoDTO;
import com.colegio.backend.dto.NotaDTO;
import com.colegio.backend.service.NotaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RestController
@RequestMapping("/api/notas")
public class NotaController {

    private final NotaService notaService;

    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    @PostMapping("/promedio")
    public ResponseEntity<Double> calcularPromedio(@Valid @RequestBody NotaCalculoDTO calculoDTO) {
        return ResponseEntity.ok(notaService.calcularPromedio(calculoDTO));
    }

    @PostMapping("/ponderado")
    public ResponseEntity<Double> calcularPonderado(@Valid @RequestBody NotaCalculoDTO calculoDTO) {
        return ResponseEntity.ok(notaService.calcularPonderado(calculoDTO));
    }

    @GetMapping("/alumno/{alumnoId}")
    public ResponseEntity<List<NotaDTO>> obtenerNotasPorAlumno(@PathVariable Long alumnoId) {
        return ResponseEntity.ok(notaService.obtenerNotasPorAlumno(alumnoId));
    }

    @PostMapping("/alumno/{alumnoId}")
    public ResponseEntity<List<NotaDTO>> guardarNotasPorAlumno(@PathVariable Long alumnoId,
                                                               @Valid @RequestBody NotaCalculoDTO calculoDTO) {
        List<NotaDTO> notasGuardadas = notaService.guardarNotasParaAlumno(alumnoId, calculoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(notasGuardadas);
    }
}
