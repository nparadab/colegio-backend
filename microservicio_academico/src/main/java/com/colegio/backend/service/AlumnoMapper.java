package com.colegio.backend.service;

import com.colegio.backend.dto.AlumnoDTO;
import com.colegio.backend.entity.Alumno;

public class AlumnoMapper {

    public static AlumnoDTO toDTO(Alumno alumno) {
        AlumnoDTO dto = new AlumnoDTO();
        dto.setId(alumno.getId());
        dto.setNombre(alumno.getNombre());
        dto.setRut(alumno.getRut());
        dto.setCurso(alumno.getCurso());
        dto.setCorreo(alumno.getCorreo());
        return dto;
    }

    public static Alumno toEntity(AlumnoDTO dto) {
        Alumno alumno = new Alumno();
        alumno.setId(dto.getId());
        alumno.setNombre(dto.getNombre());
        alumno.setRut(dto.getRut());
        alumno.setCurso(dto.getCurso());
        alumno.setCorreo(dto.getCorreo());
        return alumno;
    }
}
