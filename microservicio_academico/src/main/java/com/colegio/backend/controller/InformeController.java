package com.colegio.backend.controller;

import com.colegio.backend.dto.InformeAcademicoDTO;
import com.colegio.backend.dto.NotaCalculoDTO;
import com.colegio.backend.service.InformeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RestController
@RequestMapping("/api/informes")
public class InformeController {

    private final InformeService informeService;

    public InformeController(InformeService informeService) {
        this.informeService = informeService;
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Microservicio de informes está funcionando correctamente");
    }

    @PostMapping("/alumno/{alumnoId}")
    public ResponseEntity<?> generarInforme(@PathVariable Long alumnoId,
                                           @Valid @RequestBody NotaCalculoDTO calculoDTO) {
        System.out.println("DEBUG: Generando informe para alumnoId: " + alumnoId);
        System.out.println("DEBUG: NotaCalculoDTO - notas: " + calculoDTO.getNotas() + ", asistencia: " + calculoDTO.getAsistencia());
        
        InformeAcademicoDTO informe = informeService.generarInforme(alumnoId, calculoDTO);
        if (informe == null) {
            System.out.println("DEBUG: El alumno con ID " + alumnoId + " no fue encontrado");
            Map<String, String> error = new HashMap<>();
            error.put("error", "El alumno con ID " + alumnoId + " no existe en la base de datos");
            error.put("hint", "Verifica en http://localhost:8082/alumnos qué alumnos existen");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        return ResponseEntity.ok(informe);
    }
}
