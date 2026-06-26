package com.colegio.backend.dto;

import jakarta.validation.constraints.NotNull;

public class AsistenciaDTO {

    private Long id;

    @NotNull(message = "El alumnoId es obligatorio")
    private Long alumnoId;

    @NotNull(message = "La asistencia es obligatoria (true=asistente, false=inasistente)")
    private Boolean asistente;

    private Double porcentaje; // calculado, solo en respuestas

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Long alumnoId) {
        this.alumnoId = alumnoId;
    }

    public Boolean getAsistente() {
        return asistente;
    }

    public void setAsistente(Boolean asistente) {
        this.asistente = asistente;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }
}
