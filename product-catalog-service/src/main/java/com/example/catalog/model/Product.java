package com.example.catalog.model;

import jakarta.persistence.*;           // Importa anotações JPA para mapeamento objeto-relacional
import jakarta.validation.constraints.*; // Importa anotações para validação de dados
import java.math.BigDecimal;

@Entity // Indica que essa classe é uma entidade JPA, mapeada para uma tabela no banco de dados
public class Product {

    @Id // Define o atributo 'id' como chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID pelo banco, auto-incremento
    private Long id;

    @NotBlank // Valida que o nome não pode ser nulo nem vazio
    @Size(max = 120) // Limita o tamanho máximo do nome a 120 caracteres
    private String nome;

    @NotBlank // Valida que a descrição não pode ser nula nem vazia
    @Size(max = 500) // Limita o tamanho máximo da descrição a 500 caracteres
    private String descricao;

    @NotNull // Valida que o preço não pode ser nulo
    @DecimalMin("0.0") // O preço deve ser maior ou igual a zero
    private BigDecimal preco;

    // Construtor padrão sem argumentos (necessário para JPA)
    public Product() {}

    // Construtor com os campos nome, descricao e preco para facilitar criação do objeto
    public Product(String nome, String descricao, BigDecimal preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    // Getter e Setter para o ID
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    // Getter e Setter para o nome
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    // Getter e Setter para a descricao
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    // Getter e Setter para o preco
    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }
}
