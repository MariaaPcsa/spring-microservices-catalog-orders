package com.example.orders.dto;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public class OrderRequest {
    // Lista de IDs dos produtos incluídos no pedido.
    // A anotação @NotEmpty garante que essa lista não possa estar vazia durante a validação.
    @NotEmpty
    private List<Long> productIds;

    // Getter para obter a lista de IDs dos produtos
    public List<Long> getProductIds() { return productIds; }

    // Setter para definir a lista de IDs dos produtos
    public void setProductIds(List<Long> productIds) { this.productIds = productIds; }
}
