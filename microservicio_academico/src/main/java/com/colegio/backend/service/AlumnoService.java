package com.colegio.backend.service;

import com.colegio.backend.dto.AlumnoDTO;
import com.colegio.backend.entity.Alumno;
import com.colegio.backend.repository.AlumnoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlumnoService {

    private final AlumnoRepository repo;

    public AlumnoService(AlumnoRepository repo) {
        this.repo = repo;
    }

    public List<AlumnoDTO> listar() {
        return repo.findAll().stream().map(AlumnoMapper::toDTO).collect(Collectors.toList());
    }

    public AlumnoDTO guardar(AlumnoDTO dto) {
        Alumno alumno = AlumnoMapper.toEntity(dto);
        return AlumnoMapper.toDTO(repo.save(alumno));
    }

    public AlumnoDTO actualizar(Long id, AlumnoDTO dto) {
        Alumno alumno = AlumnoMapper.toEntity(dto);
        alumno.setId(id);
        return AlumnoMapper.toDTO(repo.save(alumno));
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    public AlumnoDTO buscarPorId(Long id) {
        return repo.findById(id).map(AlumnoMapper::toDTO).orElse(null);
    }
}
