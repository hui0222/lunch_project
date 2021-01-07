package com.example.jpa.service;

import com.example.jpa.domain.Product;
import com.example.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll(){
        List<Product> productList = productRepository.findAll();
        return productList;
    }

}
