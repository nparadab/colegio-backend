package com.colegio.backend.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class NotaCalculoDTO {

    @Valid
    private List<NotaDTO> notas;

    @NotNull(message = "El porcentaje de asistencia es obligatorio")
    @Min(value = 0, message = "La asistencia debe ser entre 0 y 100")
    @Max(value = 100, message = "La asistencia debe ser entre 0 y 100")
    private Integer asistencia;

    public List<NotaDTO> getNotas() {
        return notas;
    }

    public void setNotas(List<NotaDTO> notas) {
        this.notas = notas;
    }

    public Integer getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Integer asistencia) {
        this.asistencia = asistencia;
    }
}
