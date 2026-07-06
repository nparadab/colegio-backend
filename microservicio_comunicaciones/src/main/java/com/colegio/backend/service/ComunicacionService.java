package com.colegio.backend.service;

import com.colegio.backend.dto.AlumnoResumenDTO;
import com.colegio.backend.dto.MensajeRequest;
import com.colegio.backend.dto.MensajeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ComunicacionService {

    private static final Logger logger = LoggerFactory.getLogger(ComunicacionService.class);

    private final RestTemplate restTemplate;
    private final AtomicLong contador = new AtomicLong(1);

    @Value("${servicio.academico.url:http://localhost:8082}")
    private String urlAcademico;

    public ComunicacionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public MensajeResponse enviarMensaje(MensajeRequest request) {
        List<AlumnoResumenDTO> alumnos = buscarAlumnosRegistrados(request.getDestinatariosIds());

        MensajeResponse response = new MensajeResponse();
        response.setId(contador.getAndIncrement());
        response.setAsunto(request.getAsunto());
        response.setContenido(request.getContenido());
        response.setDestinatariosCount(alumnos.size());

        logger.info("Mensaje enviado a {} alumno(s)", alumnos.size());
        return response;
    }

    private List<AlumnoResumenDTO> buscarAlumnosRegistrados(List<Long> ids) {
        List<AlumnoResumenDTO> alumnos = new ArrayList<>();

        if (ids == null || ids.isEmpty()) {
            return alumnos;
        }

        for (Long id : ids) {
            try {
                String url = urlAcademico + "/alumnos/" + id;
                ResponseEntity<AlumnoResumenDTO> response = restTemplate.getForEntity(url, AlumnoResumenDTO.class);
                if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                    alumnos.add(response.getBody());
                }
            } catch (Exception ex) {
                logger.warn("No se pudo recuperar el alumno {} desde {}: {}", id, urlAcademico, ex.getMessage());
            }
        }

        return alumnos;
    }
}
