package com.colegio.backend.repository;

import com.colegio.backend.entity.Alumno;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AlumnoRepositoryTest {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Test
    void testGuardarYBuscarAlumno() {
        Alumno alumno = new Alumno();
        alumno.setNombre("Pedro González");
        alumno.setRut("11111111-1");
        alumno.setCurso("3B");
        alumno.setCorreo("pedro@colegio.cl");

        Alumno guardado = alumnoRepository.save(alumno);

        assertNotNull(guardado.getId());
        assertEquals("Pedro González", guardado.getNombre());

        Alumno encontrado = alumnoRepository.findById(guardado.getId()).orElse(null);
        assertNotNull(encontrado);
        assertEquals("11111111-1", encontrado.getRut());
    }
}
