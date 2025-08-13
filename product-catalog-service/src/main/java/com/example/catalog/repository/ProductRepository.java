package com.example.catalog.repository;

import com.example.catalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface que estende JpaRepository para fornecer operações CRUD e mais para a entidade Product
// JpaRepository<T, ID> recebe o tipo da entidade (Product) e o tipo do ID (Long)
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Não precisa implementar métodos, pois JpaRepository já oferece vários métodos prontos
    // como save, findById, findAll, delete, etc.
}
