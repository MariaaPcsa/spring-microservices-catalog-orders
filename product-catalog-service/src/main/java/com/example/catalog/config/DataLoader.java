package com.example.catalog.config;

import com.example.catalog.model.Product;
import com.example.catalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration // Indica que esta classe é uma configuração Spring, onde definimos beans
public class DataLoader {

    @Bean // Define um bean do tipo CommandLineRunner que será executado na inicialização da aplicação
    CommandLineRunner initData(ProductRepository repo) {
        // O método retorna uma implementação funcional (lambda) que roda quando a aplicação inicia
        return args -> {
            // Verifica se o repositório de produtos está vazio (count() == 0)
            if (repo.count() == 0) {
                // Caso esteja vazio, insere alguns produtos iniciais para popular a base
                repo.save(new Product("Caneca", "Caneca de cerâmica 300ml", new BigDecimal("29.90")));
                repo.save(new Product("Camiseta", "Camiseta 100% algodão", new BigDecimal("59.90")));
                repo.save(new Product("Caderno", "Caderno capa dura 100 folhas", new BigDecimal("19.50")));
            }
        };
    }
}
