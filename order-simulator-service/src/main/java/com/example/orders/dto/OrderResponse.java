package com.example.orders.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class OrderResponse {
    // Identificador único do pedido, gerado automaticamente usando UUID
    private String orderId;

    // Lista dos itens que compõem o pedido
    private List<OrderItem> items;

    // Valor total do pedido, somatório dos preços dos itens
    private BigDecimal total;

    // Construtor padrão sem argumentos (necessário para frameworks e serialização)
    public OrderResponse() {}

    // Construtor que inicializa os itens do pedido e o valor total
    // Também gera um orderId único automaticamente
    public OrderResponse(List<OrderItem> items, BigDecimal total) {
        this.orderId = UUID.randomUUID().toString();
        this.items = items;
        this.total = total;
    }

    // Getter para o ID do pedido
    public String getOrderId() { return orderId; }

    // Setter para o ID do pedido
    public void setOrderId(String orderId) { this.orderId = orderId; }

    // Getter para a lista de itens do pedido
    public List<OrderItem> getItems() { return items; }

    // Setter para a lista de itens do pedido
    public void setItems(List<OrderItem> items) { this.items = items; }

    // Getter para o valor total do pedido
    public BigDecimal getTotal() { return total; }

    // Setter para o valor total do pedido
    public void setTotal(BigDecimal total) { this.total = total; }
}
