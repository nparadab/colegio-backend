package com.colegio.backend.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import jakarta.validation.Validation;
import jakarta.validation.Validator;

class NotaDTOTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    void testValidNotaDTO() {
        NotaDTO dto = new NotaDTO(4.5, 20.0);

        assertTrue(validator.validate(dto).isEmpty());
    }

    @Test
    void testNullValorIsInvalid() {
        NotaDTO dto = new NotaDTO(null, 20.0);

        assertFalse(validator.validate(dto).isEmpty());
    }

    @Test
    void testNegativeValorIsInvalid() {
        NotaDTO dto = new NotaDTO(-1.0, 20.0);

        assertFalse(validator.validate(dto).isEmpty());
    }

    @Test
    void testNullPesoIsInvalid() {
        NotaDTO dto = new NotaDTO(4.5, null);

        assertFalse(validator.validate(dto).isEmpty());
    }

    @Test
    void testNegativePesoIsInvalid() {
        NotaDTO dto = new NotaDTO(4.5, -5.0);

        assertFalse(validator.validate(dto).isEmpty());
    }

    @Test
    void testValidNotaCalculoDTO() {
        NotaCalculoDTO calculo = new NotaCalculoDTO();
        List<NotaDTO> notas = new ArrayList<>();
        notas.add(new NotaDTO(4.0, 30.0));
        notas.add(new NotaDTO(5.0, 70.0));
        calculo.setNotas(notas);
        calculo.setAsistencia(95);

        assertTrue(validator.validate(calculo).isEmpty());
    }

    @Test
    void testNullAsistenciaIsInvalid() {
        NotaCalculoDTO calculo = new NotaCalculoDTO();
        List<NotaDTO> notas = new ArrayList<>();
        notas.add(new NotaDTO(4.0, 30.0));
        calculo.setNotas(notas);
        calculo.setAsistencia(null);

        assertFalse(validator.validate(calculo).isEmpty());
    }

    @Test
    void testAsistenciaBelowZeroIsInvalid() {
        NotaCalculoDTO calculo = new NotaCalculoDTO();
        List<NotaDTO> notas = new ArrayList<>();
        notas.add(new NotaDTO(4.0, 30.0));
        calculo.setNotas(notas);
        calculo.setAsistencia(-1);

        assertFalse(validator.validate(calculo).isEmpty());
    }

    @Test
    void testAsistenciaGreaterThanHundredIsInvalid() {
        NotaCalculoDTO calculo = new NotaCalculoDTO();
        List<NotaDTO> notas = new ArrayList<>();
        notas.add(new NotaDTO(4.0, 30.0));
        calculo.setNotas(notas);
        calculo.setAsistencia(101);

        assertFalse(validator.validate(calculo).isEmpty());
    }
}
