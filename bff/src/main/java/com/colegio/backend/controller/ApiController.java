package com.colegio.backend.controller;

import com.colegio.backend.dto.AlumnoDTO;
import com.colegio.backend.service.AlumnoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/alumnos")
public class ApiController {

    private final AlumnoService alumnoService;

    public ApiController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping
    public ResponseEntity<Flux<AlumnoDTO>> listar() {
        return ResponseEntity.ok(alumnoService.listarAlumnos());
    }

    @PostMapping
    public ResponseEntity<Mono<AlumnoDTO>> guardar(@Valid @RequestBody AlumnoDTO alumno) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.guardarAlumno(alumno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mono<AlumnoDTO>> actualizar(@PathVariable Long id, @Valid @RequestBody AlumnoDTO alumno) {
        return ResponseEntity.ok(alumnoService.actualizarAlumno(id, alumno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Void>> eliminar(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
