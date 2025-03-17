package com.ejercicio.ejercicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ejercicio.ejercicio.repository")
@EntityScan(basePackages = "com.ejercicio.ejercicio.model")
public class EjercicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioApplication.class, args);
	}

}
