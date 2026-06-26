package com.colegio.backend.service;

import com.colegio.backend.dto.AsistenciaDTO;
import com.colegio.backend.entity.Asistencia;
import com.colegio.backend.repository.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AsistenciaService {

    private final AsistenciaRepository repository;
    private final RestTemplate restTemplate;
    private final String academicoServiceUrl;

    public AsistenciaService(AsistenciaRepository repository, @Value("${academico.service.url}") String academicoServiceUrl) {
        this.repository = repository;
        this.restTemplate = new RestTemplate();
        this.academicoServiceUrl = academicoServiceUrl;
    }

    public AsistenciaDTO guardar(AsistenciaDTO dto) {
        verificarAlumnoExistente(dto.getAlumnoId());
        Asistencia entity = convertirAEntidad(dto);
        entity.setFecha(LocalDate.now());
        repository.save(entity);
        return convertirADTOconPorcentaje(dto.getAlumnoId());
    }

    public Optional<AsistenciaDTO> obtenerPorAlumnoId(Long alumnoId) {
        verificarAlumnoExistente(alumnoId);
        List<Asistencia> historial = repository.findByAlumnoId(alumnoId);
        if (historial.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(convertirADTOconPorcentaje(alumnoId));
    }

    public List<AsistenciaDTO> listarPorAlumnoId(Long alumnoId) {
        verificarAlumnoExistente(alumnoId);
        List<Asistencia> historial = repository.findByAlumnoId(alumnoId);
        Double porcentajeGlobal = calcularPorcentajeAsistencia(historial);
        return historial.stream()
                .map(asistencia -> {
                    AsistenciaDTO dto = new AsistenciaDTO();
                    dto.setId(asistencia.getId());
                    dto.setAlumnoId(asistencia.getAlumnoId());
                    dto.setAsistente(asistencia.getAsistente());
                    dto.setPorcentaje(porcentajeGlobal);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    private AsistenciaDTO convertirADTOconPorcentaje(Long alumnoId) {
        List<Asistencia> historial = repository.findByAlumnoId(alumnoId);
        Double porcentaje = calcularPorcentajeAsistencia(historial);
        
        Optional<Asistencia> ultima = repository.findTopByAlumnoIdOrderByFechaDesc(alumnoId);
        if (ultima.isPresent()) {
            AsistenciaDTO dto = new AsistenciaDTO();
            dto.setId(ultima.get().getId());
            dto.setAlumnoId(ultima.get().getAlumnoId());
            dto.setAsistente(ultima.get().getAsistente());
            dto.setPorcentaje(porcentaje);
            return dto;
        }
        return null;
    }

    private Double calcularPorcentajeAsistencia(List<Asistencia> historial) {
        if (historial.isEmpty()) {
            return 0.0;
        }
        long asistentes = historial.stream().filter(a -> a.getAsistente() != null && a.getAsistente()).count();
        return (double) (asistentes * 100) / historial.size();
    }

    private void verificarAlumnoExistente(Long alumnoId) {
        if (alumnoId == null || alumnoId <= 0 || !alumnoExiste(alumnoId)) {
            throw new IllegalArgumentException("El alumno con id " + alumnoId + " no existe");
        }
    }

    private boolean alumnoExiste(Long alumnoId) {
        try {
            restTemplate.getForEntity(academicoServiceUrl + "/alumnos/{id}", String.class, alumnoId);
            return true;
        } catch (HttpClientErrorException.NotFound ex) {
            return false;
        } catch (HttpClientErrorException ex) {
            throw new RuntimeException("Error al verificar existencia del alumno: " + ex.getMessage(), ex);
        }
    }

    private AsistenciaDTO convertirADTO(Asistencia asistencia) {
        AsistenciaDTO dto = new AsistenciaDTO();
        dto.setId(asistencia.getId());
        dto.setAlumnoId(asistencia.getAlumnoId());
        dto.setAsistente(asistencia.getAsistente());
        return dto;
    }

    private Asistencia convertirAEntidad(AsistenciaDTO dto) {
        Asistencia entity = new Asistencia();
        entity.setId(dto.getId());
        entity.setAlumnoId(dto.getAlumnoId());
        entity.setAsistente(dto.getAsistente());
        entity.setFecha(LocalDate.now());
        return entity;
    }
}
