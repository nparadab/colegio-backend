package com.colegio.backend.dto;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

class AlumnoDTOTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    void testValidAlumnoDTO() {
        AlumnoDTO dto = new AlumnoDTO();
        dto.setNombre("Ana Pasarín");
        dto.setRut("98765432-1");
        dto.setCurso("4A");
        dto.setCorreo("ana@colegio.cl");

        assertTrue(validator.validate(dto).isEmpty());
    }

    @Test
    void testInvalidCorreo() {
        AlumnoDTO dto = new AlumnoDTO();
        dto.setNombre("Ana Pasarín");
        dto.setRut("98765432-1");
        dto.setCurso("4A");
        dto.setCorreo("correo_invalido");

        assertFalse(validator.validate(dto).isEmpty());
    }

    @Test
    void testBlankNombreIsInvalid() {
        AlumnoDTO dto = new AlumnoDTO();
        dto.setNombre("   ");
        dto.setRut("98765432-1");
        dto.setCurso("4A");
        dto.setCorreo("ana@colegio.cl");

        assertFalse(validator.validate(dto).isEmpty());
    }

    @Test
    void testBlankRutIsInvalid() {
        AlumnoDTO dto = new AlumnoDTO();
        dto.setNombre("Ana Pasarín");
        dto.setRut("   ");
        dto.setCurso("4A");
        dto.setCorreo("ana@colegio.cl");

        assertFalse(validator.validate(dto).isEmpty());
    }

    @Test
    void testBlankCursoIsInvalid() {
        AlumnoDTO dto = new AlumnoDTO();
        dto.setNombre("Ana Pasarín");
        dto.setRut("98765432-1");
        dto.setCurso("   ");
        dto.setCorreo("ana@colegio.cl");

        assertFalse(validator.validate(dto).isEmpty());
    }
}
