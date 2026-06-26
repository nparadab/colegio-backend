package com.colegio.backend.strategy;

import com.colegio.backend.dto.NotaDTO;

import java.util.List;

public class PromedioStrategy implements NotaStrategy {
    @Override
    public double calcularNota(List<NotaDTO> notas, int asistencia) {
        double promedio = notas.stream()
                .mapToDouble(NotaDTO::getValor)
                .average()
                .orElse(0);
        double factorAsistencia = 0.6 + 0.4 * (asistencia / 100.0);
        return Math.round(promedio * factorAsistencia * 100.0) / 100.0;
    }
}
