package com.colegio.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class NotaDTO {

    @NotNull(message = "El valor de la nota es obligatorio")
    @Min(value = 0, message = "La nota debe ser mayor o igual a 0")
    private Double valor;

    @NotNull(message = "El peso de la nota es obligatorio")
    @Min(value = 0, message = "El peso debe ser mayor o igual a 0")
    private Double peso;

    public NotaDTO() {
    }

    public NotaDTO(Double valor, Double peso) {
        this.valor = valor;
        this.peso = peso;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
