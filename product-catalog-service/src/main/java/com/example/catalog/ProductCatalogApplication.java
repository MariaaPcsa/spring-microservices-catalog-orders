package com.example.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Indica que esta é a classe principal da aplicação Spring Boot.
// @SpringBootApplication combina:
// - @Configuration: indica que essa classe pode conter beans.
// - @EnableAutoConfiguration: habilita a configuração automática do Spring Boot.
// - @ComponentScan: escaneia os pacotes para encontrar componentes, serviços e controladores.
@SpringBootApplication
public class ProductCatalogApplication {

    // Método principal que inicia a aplicação Spring Boot
    public static void main(String[] args) {
        SpringApplication.run(ProductCatalogApplication.class, args);
    }
}
