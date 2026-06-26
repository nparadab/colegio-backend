# BFF (Backend For Frontend)

## Descripción
Este módulo actúa como intermediario entre el frontend React y los microservicios del backend. Expone endpoints REST unificados para la gestión de alumnos y simplifica la comunicación en la aplicación.

## Requisitos
- Java 17
- Maven 3.9+
- Spring Boot 3.x

## Instalación
Desde el directorio `bff`:

```bash
cd colegio-backend-main/colegio-backend-main/bff
mvn clean install
```

## Ejecución
```bash
mvn spring-boot:run
```

El servicio arranca en `http://localhost:8081`.

## Endpoints
- `GET /api/alumnos` → obtener listado de alumnos
- `POST /api/alumnos` → crear un nuevo alumno
- `PUT /api/alumnos/{id}` → actualizar datos de un alumno existente
- `DELETE /api/alumnos/{id}` → eliminar un alumno

## Pruebas
```bash
mvn test
```

Este comando ejecuta las pruebas del módulo BFF y valida su compilación. El BFF está diseñado para integrarse con el microservicio académico, pero en el estado actual solo maneja alumnos.
