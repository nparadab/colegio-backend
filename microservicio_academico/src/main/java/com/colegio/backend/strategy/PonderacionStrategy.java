package com.colegio.backend.strategy;

import com.colegio.backend.dto.NotaDTO;

import java.util.List;

public class PonderacionStrategy implements NotaStrategy {

    @Override
    public double calcularNota(List<NotaDTO> notas, int porcentajeAsistencia) {
        double totalPeso = notas.stream().mapToDouble(NotaDTO::getPeso).sum();
        double sumaPonderada = notas.stream()
                .mapToDouble(nota -> nota.getValor() * nota.getPeso())
                .sum();

        double promedioBase = totalPeso > 0 ? sumaPonderada / totalPeso : notas.stream().mapToDouble(NotaDTO::getValor).average().orElse(0);
        double factorAsistencia = 0.6 + 0.4 * (porcentajeAsistencia / 100.0);
        double notaFinal = promedioBase * factorAsistencia;
        return Math.round(notaFinal * 100.0) / 100.0;
    }
}
