package com.colegio.backend.dto;

public class MensajeResponse {

    private Long id;
    private String asunto;
    private String contenido;
    private int destinatariosCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public int getDestinatariosCount() {
        return destinatariosCount;
    }

    public void setDestinatariosCount(int destinatariosCount) {
        this.destinatariosCount = destinatariosCount;
    }
}
