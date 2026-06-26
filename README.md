# Backend Colegio

## Descripción
Este es el proyecto backend del sistema escolar. Está organizado como un proyecto Maven multimódulo que incluye un BFF, un microservicio académico, un microservicio de asistencia y un módulo de comunicaciones.

## Módulos incluidos
- `bff`: Backend For Frontend que expone los endpoints de gestión de alumnos para el frontend.
- `microservicio_academico`: implementa la lógica de alumnos, notas e informes académicos.
- `microservicio_asistencia`: gestiona el registro de asistencia y calcula porcentajes históricos.
- `microservicio_comunicaciones`: módulo inicializado pero actualmente no tiene controladores ni lógica de servicio implementada.

## Requisitos
- Java 17
- Maven 3.9+
- PostgreSQL o un servicio compatible con JDBC

## Instalación
Desde el directorio `colegio-backend-main/colegio-backend-main`:

```bash
mvn clean install
```

## Ejecución
Cada módulo puede ejecutarse de forma independiente desde su directorio respectivo:

```bash
cd bff
mvn spring-boot:run
```

```bash
cd microservicio_academico
mvn spring-boot:run
```

```bash
cd microservicio_asistencia
mvn spring-boot:run
```

## Puertos por módulo
- BFF: `http://localhost:8081`
- Microservicio académico: `http://localhost:8082`
- Microservicio de asistencia: `http://localhost:8083`

## Endpoints principales implementados
- `bff`:
  - `GET /api/alumnos`
  - `POST /api/alumnos`
  - `PUT /api/alumnos/{id}`
  - `DELETE /api/alumnos/{id}`
- `microservicio_academico`:
  - `GET /alumnos`
  - `POST /alumnos`
  - `PUT /alumnos/{id}`
  - `DELETE /alumnos/{id}`
  - `POST /api/notas/promedio`
  - `POST /api/notas/ponderado`
  - `GET /api/notas/alumno/{alumnoId}`
  - `POST /api/notas/alumno/{alumnoId}`
  - `POST /api/informes/alumno/{alumnoId}`
- `microservicio_asistencia`:
  - `GET /api/asistencia/alumno/{alumnoId}`
  - `GET /api/asistencia/alumno/{alumnoId}/historial`
  - `POST /api/asistencia`

## Pruebas
Para ejecutar las pruebas unitarias de todos los módulos:

```bash
mvn test
```

## Dependencias principales
- Spring Boot
- Spring Data JPA
- Reactor / WebFlux
- Lombok

## Notas
- `microservicio_comunicaciones` está presente como scaffolding y no contiene endpoints funcionales.
- El BFF actualmente se usa principalmente para gestionar alumnos, mientras que otras operaciones del frontend se conectan directamente a los microservicios de académico y asistencia.


WebClient

Nota
Los módulos microservicio_asistencia y microservicio_comunicaciones se encuentran en desarrollo y aún no implementan lógica funcional.
