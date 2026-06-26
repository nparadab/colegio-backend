package com.colegio.backend.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI academicoOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Microservicio Académico")
                        .description("Servicios de alumnos, notas e informes académicos")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Equipo Académico")
                                .email("soporte@colegio.cl"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Repositorio del microservicio académico")
                        .url("https://github.com/colegio/backend"));
    }
}
