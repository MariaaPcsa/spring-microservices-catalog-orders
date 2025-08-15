package com.example.orders.controller;

import com.example.orders.dto.*;
import com.example.orders.service.CatalogClient;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")

@RestController
@RequestMapping("/pedidos")  // Define a URL base para os endpoints deste controller
public class OrderController {

    private final CatalogClient catalogClient;  // Cliente para comunicação com o serviço de catálogo de produtos

    public OrderController(CatalogClient catalogClient) {
        this.catalogClient = catalogClient;
    }

    // Endpoint GET para listar todos os produtos disponíveis
    @GetMapping(value="/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<List<ProductDto>> produtosDisponiveis() {
        // Retorna um Mono contendo a lista de produtos obtida via CatalogClient
        return catalogClient.getAllProducts();
    }

    // Endpoint POST para simular um pedido com base em uma lista de IDs de produtos
    @PostMapping
    public Mono<OrderResponse> simularPedido(@Valid @RequestBody OrderRequest req) {
        // Cria um Flux a partir da lista de IDs de produtos recebida na requisição
        return Flux.fromIterable(req.getProductIds())
                // Para cada ID, obtém os dados completos do produto via CatalogClient (de forma assíncrona)
                .flatMap(pid -> catalogClient.getProductById(pid))
                // Mapeia cada produto recebido para um OrderItem (detalhe do item do pedido)
                .map(p -> new OrderItem(p.getId(), p.getNome(), p.getPreco()))
                // Coleta todos os OrderItems em uma lista
                .collectList()
                // Calcula o valor total do pedido somando os preços dos itens
                .map(list -> {
                    BigDecimal total = list.stream()
                            .map(OrderItem::getPreco)
                            .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));  // Soma os preços evitando ambiguidade no método add
                    // Retorna um objeto OrderResponse com a lista de itens e o total calculado
                    return new OrderResponse(list, total);
                });
    }
}
