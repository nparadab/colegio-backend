package com.colegio.backend.repository;

import com.colegio.backend.entity.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {
    List<Asistencia> findByAlumnoId(Long alumnoId);
    Optional<Asistencia> findTopByAlumnoIdOrderByFechaDesc(Long alumnoId);
}
