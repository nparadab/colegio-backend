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
        return repo.findAll().stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    public AlumnoDTO guardar(AlumnoDTO dto) {
        Alumno alumno = convertirAEntidad(dto);
        return convertirADTO(repo.save(alumno));
    }

    public AlumnoDTO actualizar(Long id, AlumnoDTO dto) {
        Alumno alumno = convertirAEntidad(dto);
        alumno.setId(id);
        return convertirADTO(repo.save(alumno));
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    private AlumnoDTO convertirADTO(Alumno alumno) {
        AlumnoDTO dto = new AlumnoDTO();
        dto.setId(alumno.getId());
        dto.setNombre(alumno.getNombre());
        dto.setRut(alumno.getRut());
        dto.setCurso(alumno.getCurso());
        dto.setCorreo(alumno.getCorreo());
        return dto;
    }

    private Alumno convertirAEntidad(AlumnoDTO dto) {
        Alumno alumno = new Alumno();
        alumno.setId(dto.getId());
        alumno.setNombre(dto.getNombre());
        alumno.setRut(dto.getRut());
        alumno.setCurso(dto.getCurso());
        alumno.setCorreo(dto.getCorreo());
        return alumno;
    }
}
