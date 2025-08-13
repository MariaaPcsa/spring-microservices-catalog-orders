package com.example.orders.dto;

import java.math.BigDecimal;

public class ProductDto {
    // Identificador único do produto
    private Long id;

    // Nome do produto
    private String nome;

    // Descrição detalhada do produto
    private String descricao;

    // Preço do produto, representado como BigDecimal para precisão financeira
    private BigDecimal preco;

    // Getter para o ID do produto
    public Long getId() { return id; }

    // Setter para o ID do produto
    public void setId(Long id) { this.id = id; }

    // Getter para o nome do produto
    public String getNome() { return nome; }

    // Setter para o nome do produto
    public void setNome(String nome) { this.nome = nome; }

    // Getter para a descrição do produto
    public String getDescricao() { return descricao; }

    // Setter para a descrição do produto
    public void setDescricao(String descricao) { this.descricao = descricao; }

    // Getter para o preço do produto
    public BigDecimal getPreco() { return preco; }

    // Setter para o preço do produto
    public void setPreco(BigDecimal preco) { this.preco = preco; }
}
