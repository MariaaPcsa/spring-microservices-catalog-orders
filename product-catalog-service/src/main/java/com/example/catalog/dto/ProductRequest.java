package com.example.catalog.dto;

import jakarta.validation.constraints.*; // Importa as anotações para validação de dados
import java.math.BigDecimal;

public class ProductRequest {
    // O nome do produto não pode ser vazio (NotBlank) e deve ter no máximo 120 caracteres
    @NotBlank
    @Size(max = 120)
    private String nome;

    // A descrição do produto não pode ser vazia e deve ter no máximo 500 caracteres
    @NotBlank
    @Size(max = 500)
    private String descricao;

    // O preço não pode ser nulo e deve ser no mínimo 0.0 (valor positivo ou zero)
    @NotNull
    @DecimalMin("0.0")
    private BigDecimal preco;

    // Getter e Setter para nome
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    // Getter e Setter para descricao
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    // Getter e Setter para preco
    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }
}
