package com.colegio.backend.service;

import com.colegio.backend.dto.NotaCalculoDTO;
import com.colegio.backend.dto.NotaDTO;
import com.colegio.backend.service.NotaPersistenciaService;
import com.colegio.backend.strategy.NotaStrategy;
import com.colegio.backend.strategy.PonderacionStrategy;
import com.colegio.backend.strategy.PromedioStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotaService {
    private final NotaStrategy promedioStrategy = new PromedioStrategy();
    private final NotaStrategy ponderacionStrategy = new PonderacionStrategy();
    private final NotaPersistenciaService notaPersistenciaService;

    public NotaService(NotaPersistenciaService notaPersistenciaService) {
        this.notaPersistenciaService = notaPersistenciaService;
    }

    public double calcularPromedio(NotaCalculoDTO calculoDTO) {
        return promedioStrategy.calcularNota(calculoDTO.getNotas(), calculoDTO.getAsistencia());
    }

    public double calcularPonderado(NotaCalculoDTO calculoDTO) {
        return ponderacionStrategy.calcularNota(calculoDTO.getNotas(), calculoDTO.getAsistencia());
    }

    public double calcularPonderado(List<NotaDTO> notas, int asistencia) {
        return ponderacionStrategy.calcularNota(notas, asistencia);
    }

    public List<NotaDTO> obtenerNotasPorAlumno(Long alumnoId) {
        return notaPersistenciaService.obtenerNotasPorAlumno(alumnoId);
    }

    public List<NotaDTO> guardarNotasParaAlumno(Long alumnoId, NotaCalculoDTO calculoDTO) {
        notaPersistenciaService.eliminarNotasPorAlumno(alumnoId);
        return calculoDTO.getNotas().stream()
                .map(notaDTO -> notaPersistenciaService.guardarNotaParaAlumno(alumnoId, notaDTO))
                .collect(Collectors.toList());
    }
}
