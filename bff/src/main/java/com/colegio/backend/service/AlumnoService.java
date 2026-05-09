package com.colegio.backend.service;

import com.colegio.backend.dto.AlumnoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AlumnoService {

    private final WebClient webClient;
    private final String baseUrl;

    public AlumnoService(WebClient webClient, @Value("${academico.url}") String baseUrl) {
        this.webClient = webClient;
        this.baseUrl = baseUrl;
    }

    public Flux<AlumnoDTO> listarAlumnos() {
        return webClient.get()
                .uri(baseUrl + "/alumnos")
                .retrieve()
                .bodyToFlux(AlumnoDTO.class);
    }

    public Mono<AlumnoDTO> guardarAlumno(AlumnoDTO alumno) {
        return webClient.post()
                .uri(baseUrl + "/alumnos")
                .bodyValue(alumno)
                .retrieve()
                .bodyToMono(AlumnoDTO.class);
    }

    public Mono<AlumnoDTO> actualizarAlumno(Long id, AlumnoDTO alumno) {
        return webClient.put()
                .uri(baseUrl + "/alumnos/{id}", id)
                .bodyValue(alumno)
                .retrieve()
                .bodyToMono(AlumnoDTO.class);
    }

    public Mono<Void> eliminarAlumno(Long id) {
        return webClient.delete()
                .uri(baseUrl + "/alumnos/{id}", id)
                .retrieve()
                .bodyToMono(Void.class);
    }
}
