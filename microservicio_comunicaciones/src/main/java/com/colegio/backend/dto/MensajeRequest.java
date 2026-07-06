package com.colegio.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public class MensajeRequest {

    @NotBlank(message = "El asunto es obligatorio")
    private String asunto;

    @NotBlank(message = "El contenido es obligatorio")
    private String contenido;

    @NotEmpty(message = "Debe indicar al menos un destinatario")
    private List<Long> destinatariosIds;

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public List<Long> getDestinatariosIds() {
        return destinatariosIds;
    }

    public void setDestinatariosIds(List<Long> destinatariosIds) {
        this.destinatariosIds = destinatariosIds;
    }
}
