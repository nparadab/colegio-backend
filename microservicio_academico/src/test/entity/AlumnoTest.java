package com.colegio.backend.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AlumnoTest {

    @Test
    void testCrearAlumno() {
        Alumno alumno = new Alumno();
        alumno.setNombre("Juan Pérez");
        alumno.setRut("12345678-9");
        alumno.setCurso("4D");
        alumno.setCorreo("juan@colegio.cl");

        assertEquals("Juan Pérez", alumno.getNombre());
        assertEquals("12345678-9", alumno.getRut());
        assertEquals("4D", alumno.getCurso());
        assertEquals("juan@colegio.cl", alumno.getCorreo());
    }
}
