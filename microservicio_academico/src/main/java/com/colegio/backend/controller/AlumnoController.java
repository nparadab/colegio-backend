package com.colegio.backend.controller;

import com.colegio.backend.dto.AlumnoDTO;
import com.colegio.backend.service.AlumnoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    private final AlumnoService service;

    public AlumnoController(AlumnoService service) {
        this.service = service;
    }

    @GetMapping
    public List<AlumnoDTO> listar() {
        return service.listar();
    }

    @PostMapping
    public AlumnoDTO guardar(@RequestBody AlumnoDTO alumno) {
        return service.guardar(alumno);
    }

    @PutMapping("/{id}")
    public AlumnoDTO actualizar(@PathVariable Long id, @RequestBody AlumnoDTO alumno) {
        return service.actualizar(id, alumno);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
