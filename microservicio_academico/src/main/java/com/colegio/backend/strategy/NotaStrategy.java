package com.colegio.backend.strategy;

import com.colegio.backend.dto.NotaDTO;

import java.util.List;

public interface NotaStrategy {
    double calcularNota(List<NotaDTO> notas, int asistencia);
}
