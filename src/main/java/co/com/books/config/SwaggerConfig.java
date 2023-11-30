package co.com.books.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "API para el servicio de prestamos de libros", version = "1.0",
        description = "API que expone los endpoints para gestionar los prestamos de libros"))
public class SwaggerConfig {
}
