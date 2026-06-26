package com.colegio.backend.service;

import com.colegio.backend.dto.NotaDTO;
import com.colegio.backend.entity.Nota;
import com.colegio.backend.repository.NotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotaPersistenciaService {

    private final NotaRepository notaRepository;

    public NotaPersistenciaService(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    public NotaDTO guardarNotaParaAlumno(Long alumnoId, NotaDTO notaDTO) {
        Nota nota = new Nota();
        nota.setAlumnoId(alumnoId);
        nota.setValor(notaDTO.getValor());
        nota.setPeso(notaDTO.getPeso());
        Nota guardada = notaRepository.save(nota);
        return toDTO(guardada);
    }

    public List<NotaDTO> obtenerNotasPorAlumno(Long alumnoId) {
        return notaRepository.findByAlumnoId(alumnoId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public void eliminarNotasPorAlumno(Long alumnoId) {
        notaRepository.findByAlumnoId(alumnoId).forEach(notaRepository::delete);
    }

    private NotaDTO toDTO(Nota nota) {
        NotaDTO dto = new NotaDTO();
        dto.setValor(nota.getValor());
        dto.setPeso(nota.getPeso());
        return dto;
    }
}
