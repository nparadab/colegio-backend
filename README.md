Colegio Backend
Descripción
Proyecto Maven multimódulo que contiene los microservicios del sistema académico y el BFF.

Módulos incluidos
bff: Backend For Frontend, expone endpoints REST simplificados para el frontend.

microservicio_academico: CRUD de cursos, asignaturas y evaluaciones.

microservicio_asistencia: estructura creada, pendiente de implementación.

microservicio_comunicaciones: estructura creada, pendiente de implementación.

Instalación
Para compilar todos los módulos:
mvn clean install

Ejecución
Cada módulo puede ejecutarse de manera independiente:
mvn spring-boot:run

Endpoints principales (implementados)
Los siguientes endpoints están activos en los módulos actuales:

/api/alumnos → listado de alumnos (BFF)

/api/cursos → gestión de cursos (académico)

/api/evaluaciones → gestión de evaluaciones (académico)

Pruebas
Ejecutar pruebas unitarias:
mvn test

Dependencias principales
Spring Boot

Spring Data JPA

Lombok

WebClient

Nota
Los módulos microservicio_asistencia y microservicio_comunicaciones se encuentran en desarrollo y aún no implementan lógica funcional.
