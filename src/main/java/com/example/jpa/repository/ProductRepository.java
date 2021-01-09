package com.example.jpa.repository;

import com.example.jpa.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    Product findAllByProductId(String id);
    Product findByProductId(int productId);
    Product findByProductCode(String productCode);
}
