## Microservicio Académico

## Descripción
Gestiona la información de alumnos del Colegio Bernardo O’Higgins. Expone endpoints REST para CRUD de alumnos.

## Requisitos
Java 17
Maven 3.9+
PostgreSQL (o Docker con imagen postgres:15)
Spring Boot 3.x

## Instalación
Código
cd microservicio_academico
mvn clean install

## Ejecución
Código
mvn spring-boot:run
El servicio se levanta en http://localhost:8080/

## Endpoints
GET /api/alumnos → obtener listado de alumnos
POST /api/alumnos → crear un nuevo alumno
PUT /api/alumnos/{id} → actualizar datos de un alumno existente
DELETE /api/alumnos/{id} → eliminar un alumno

## Pruebas
mvn test  
Ejecuta las pruebas unitarias (AlumnoTest, AlumnoDTOTest, AlumnoRepositoryTest).
