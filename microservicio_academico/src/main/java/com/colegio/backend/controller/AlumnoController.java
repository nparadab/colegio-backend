package com.colegio.backend.controller;

import com.colegio.backend.dto.AlumnoDTO;
import com.colegio.backend.service.AlumnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    private final AlumnoService service;

    public AlumnoController(AlumnoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AlumnoDTO>> listar() {
        List<AlumnoDTO> alumnos = service.listar();
        return ResponseEntity.ok(alumnos);
    }

    @PostMapping
    public ResponseEntity<AlumnoDTO> guardar(@Valid @RequestBody AlumnoDTO alumno) {
        AlumnoDTO creado = service.guardar(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoDTO> actualizar(@PathVariable Long id, @Valid @RequestBody AlumnoDTO alumno) {
        AlumnoDTO actualizado = service.actualizar(id, alumno);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
