package com.colegio.backend.service;

import com.colegio.backend.dto.AlumnoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AlumnoService {

    private final WebClient webClient;

    public AlumnoService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<AlumnoDTO> listarAlumnos() {
        return webClient.get()
                .uri("http://localhost:8082/alumnos") // microservicio académico
                .retrieve()
                .bodyToFlux(AlumnoDTO.class);
    }

    public Mono<AlumnoDTO> guardarAlumno(AlumnoDTO alumno) {
        return webClient.post()
                .uri("http://localhost:8082/alumnos")
                .bodyValue(alumno)
                .retrieve()
                .bodyToMono(AlumnoDTO.class);
    }

    public Mono<AlumnoDTO> actualizarAlumno(Long id, AlumnoDTO alumno) {
        return webClient.put()
                .uri("http://localhost:8082/alumnos/{id}", id)
                .bodyValue(alumno)
                .retrieve()
                .bodyToMono(AlumnoDTO.class);
    }

    public Mono<Void> eliminarAlumno(Long id) {
        return webClient.delete()
                .uri("http://localhost:8082/alumnos/{id}", id)
                .retrieve()
                .bodyToMono(Void.class);
    }
}
