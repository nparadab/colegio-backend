package com.colegio.backend.controller;

import com.colegio.backend.dto.MensajeRequest;
import com.colegio.backend.dto.MensajeResponse;
import com.colegio.backend.service.ComunicacionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ComunicacionController.class)
class ComunicacionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ComunicacionService comunicacionService;

    @Test
    void enviarMensajeDeberiaRetornar201() throws Exception {
        MensajeRequest request = new MensajeRequest();
        request.setAsunto("Recordatorio");
        request.setContenido("Hola, este es un mensaje de prueba");
        request.setDestinatariosIds(List.of(1L));

        MensajeResponse response = new MensajeResponse();
        response.setId(1L);
        response.setAsunto("Recordatorio");
        response.setContenido("Hola, este es un mensaje de prueba");
        response.setDestinatariosCount(1);

        when(comunicacionService.enviarMensaje(any(MensajeRequest.class))).thenReturn(response);

        mockMvc.perform(post("/api/comunicaciones/enviar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.asunto").value("Recordatorio"));
    }
}
