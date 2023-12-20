package com.example.Product.repo;

import com.example.Product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product getProductById(Long id);

}
