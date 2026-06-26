## BFF (Backend For Frontend)

## Descripción
Este módulo actúa como intermediario entre el frontend React y los microservicios del backend. Expone endpoints REST unificados para simplificar la comunicación y aplicar validaciones globales.

## Requisitos
Java 17
Maven 3.9+
Spring Boot 3.x

## Instalación
Código
cd bff
mvn clean install

## Ejecución
Código
mvn spring-boot:run
El servicio se levanta en http://localhost:8081/

## Endpoints
GET /api/alumnos → obtener listado de alumnos
POST /api/alumnos → crear un nuevo alumno
PUT /api/alumnos/{id} → actualizar datos de un alumno existente
DELETE /api/alumnos/{id} → eliminar un alumno

## Pruebas
Código
mvn test
Ejecuta las pruebas unitarias del BFF y valida la conexión con los microservicios.