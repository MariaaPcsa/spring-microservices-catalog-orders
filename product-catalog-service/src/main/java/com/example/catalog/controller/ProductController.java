package com.example.catalog.controller;

import com.example.catalog.dto.ProductRequest;
import com.example.catalog.model.Product;
import com.example.catalog.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173") // Permite requisições do frontend React
@RestController // Indica que essa classe é um controller REST e que os métodos retornam dados JSON
@RequestMapping("/produtos") // Mapeia todas as requisições iniciadas com /produtos para esse controller
public class ProductController {

    private final ProductRepository repository; // Repositório para acessar os dados de Product

    // Injeção via construtor do repositório
    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    // Endpoint POST para criar um novo produto
    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody ProductRequest req) {
        // Converte o DTO ProductRequest para a entidade Product e salva no banco
        Product saved = repository.save(new Product(req.getNome(), req.getDescricao(), req.getPreco()));
        // Retorna HTTP 201 Created com o local do novo recurso no header Location e o produto no body
        return ResponseEntity.created(URI.create("/produtos/" + saved.getId())).body(saved);
    }

    // Endpoint GET para listar todos os produtos
    @GetMapping
    public List<Product> list() {
        // Retorna a lista de todos os produtos do banco
        return repository.findAll();
    }

    // Endpoint GET para buscar um produto específico pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id) {
        // Busca o produto por ID e retorna 200 OK com o produto, ou 404 Not Found se não existir
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
