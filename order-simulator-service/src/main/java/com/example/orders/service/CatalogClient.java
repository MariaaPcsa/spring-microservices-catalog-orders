package com.example.orders.service;

import com.example.orders.dto.ProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CatalogClient {

    private final WebClient webClient;

    public CatalogClient(WebClient.Builder builder,
                         @Value("${catalog.service.base-url}") String baseUrl) {
        this.webClient = builder.baseUrl(baseUrl).build();
    }

    public Mono<List<ProductDto>> getAllProducts() {
        return webClient.get()
                .uri("/produtos")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<ProductDto>>() {});
    }

    public Mono<ProductDto> getProductById(Long id) {
        return webClient.get()
                .uri("/produtos/{id}", id)
                .retrieve()
                .bodyToMono(ProductDto.class);
    }
}
