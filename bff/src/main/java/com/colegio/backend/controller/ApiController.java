package com.colegio.backend.controller;

import com.colegio.backend.dto.AlumnoDTO;
import com.colegio.backend.service.AlumnoService;
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
    public Flux<AlumnoDTO> listar() {
        return alumnoService.listarAlumnos();
    }

    @PostMapping
    public Mono<AlumnoDTO> guardar(@RequestBody AlumnoDTO alumno) {
        return alumnoService.guardarAlumno(alumno);
    }

    @PutMapping("/{id}")
    public Mono<AlumnoDTO> actualizar(@PathVariable Long id, @RequestBody AlumnoDTO alumno) {
        return alumnoService.actualizarAlumno(id, alumno);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminar(@PathVariable Long id) {
        return alumnoService.eliminarAlumno(id);
    }
}
