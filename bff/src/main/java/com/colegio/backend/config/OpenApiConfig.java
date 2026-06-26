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
    public OpenAPI colegioOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Colegio BFF")
                        .description("API Gateway y agregación de servicios para el backend del colegio")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Equipo Backend Colegio")
                                .email("soporte@colegio.cl"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentación del backend")
                        .url("https://github.com/colegio/backend"));
    }
}
