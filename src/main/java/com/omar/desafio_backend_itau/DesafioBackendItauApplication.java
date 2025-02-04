package com.omar.desafio_backend_itau;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "Desafio Backend Junior Itaú",
		version = "1.0",
		description = "API para resolução do desafio backend junior do itaú, presente no github: https://github.com/rafaellins-itau/desafio-itau-vaga-99-junior"
))
public class DesafioBackendItauApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioBackendItauApplication.class, args);
	}

}
