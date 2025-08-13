package com.example.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // Marca esta classe como ponto de entrada do aplicativo Spring Boot
public class OrderSimulatorApplication {

    // Método principal que inicia a aplicação Spring Boot
    public static void main(String[] args) {
        SpringApplication.run(OrderSimulatorApplication.class, args);
    }
}
