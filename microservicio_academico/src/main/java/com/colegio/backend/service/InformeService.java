package com.colegio.backend.service;

import com.colegio.backend.dto.InformeAcademicoDTO;
import com.colegio.backend.dto.NotaCalculoDTO;
import org.springframework.stereotype.Service;

@Service
public class InformeService {

    private final AlumnoService alumnoService;
    private final NotaService notaService;

    public InformeService(AlumnoService alumnoService, NotaService notaService) {
        this.alumnoService = alumnoService;
        this.notaService = notaService;
    }

    public InformeAcademicoDTO generarInforme(Long alumnoId, NotaCalculoDTO calculoDTO) {
        var alumno = alumnoService.buscarPorId(alumnoId);
        if (alumno == null) {
            return null;
        }

        var notas = calculoDTO.getNotas();
        if (notas == null || notas.isEmpty()) {
            notas = notaService.obtenerNotasPorAlumno(alumnoId);
        }

        double promedioFinal = notaService.calcularPonderado(notas, calculoDTO.getAsistencia());
        InformeAcademicoDTO informe = new InformeAcademicoDTO();
        informe.setAlumno(alumno);
        informe.setNotas(notas);
        informe.setAsistencia(calculoDTO.getAsistencia());
        informe.setPromedioFinal(promedioFinal);
        informe.setEstado(obtenerEstado(promedioFinal, calculoDTO.getAsistencia()));
        return informe;
    }

    private String obtenerEstado(double promedio, int asistencia) {
        if (asistencia < 75) {
            return "Revisar asistencia";
        }
        if (promedio >= 4.0) {
            return "Aprobado";
        }
        return "Reprobado";
    }
}
