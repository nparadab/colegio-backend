# Microservicio Académico

## Descripción
Este microservicio gestiona los datos académicos del sistema. Implementa operaciones de alumnos, notas e informes, y expone endpoints REST para el frontend y otros servicios.

## Requisitos
- Java 17
- Maven 3.9+
- PostgreSQL o un servicio compatible con JDBC
- Spring Boot 3.x

## Instalación
Desde el directorio `microservicio_academico`:

```bash
cd colegio-backend-main/colegio-backend-main/microservicio_academico
mvn clean install
```

## Ejecución
```bash
mvn spring-boot:run
```

El servicio arranca en `http://localhost:8082`.

## Endpoints
- `GET /alumnos` → obtener listado de alumnos
- `POST /alumnos` → crear un nuevo alumno
- `PUT /alumnos/{id}` → actualizar datos de un alumno existente
- `DELETE /alumnos/{id}` → eliminar un alumno
- `POST /api/notas/promedio` → calcular promedio simple
- `POST /api/notas/ponderado` → calcular promedio ponderado
- `GET /api/notas/alumno/{alumnoId}` → obtener notas guardadas de un alumno
- `POST /api/notas/alumno/{alumnoId}` → guardar notas para un alumno
- `POST /api/informes/alumno/{alumnoId}` → generar informe académico para un alumno

## Pruebas
```bash
mvn test
```

Ejecuta las pruebas unitarias del microservicio, incluyendo validación de DTOs, repositorios y entidades.

## Notas
- Los datos se almacenan en PostgreSQL según la configuración de `application.properties`.
- Este servicio es consumido por el BFF y por los servicios de notas e informes del frontend.
