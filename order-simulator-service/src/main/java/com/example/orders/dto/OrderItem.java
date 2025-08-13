package com.example.orders.dto;

import java.math.BigDecimal;

public class OrderItem {
    // ID do produto associado a este item do pedido
    private Long productId;

    // Nome do produto
    private String nome;

    // Preço do produto
    private BigDecimal preco;

    // Construtor padrão necessário para frameworks e serialização
    public OrderItem() {}

    // Construtor que inicializa todos os campos
    public OrderItem(Long productId, String nome, BigDecimal preco) {
        this.productId = productId;
        this.nome = nome;
        this.preco = preco;
    }

    // Getters e setters para acesso e modificação dos atributos

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }
}
