package com.example.jpa.controller;

import com.example.jpa.domain.Product;
import com.example.jpa.repository.ProductRepository;
import com.example.jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;


    @RequestMapping(path = "/product/list",method = RequestMethod.GET)
    public List<Product> getProductList() {

        List<Product> productList = productService.findAll();

        return productList;
    }

    @RequestMapping(path = "/product/detail/{productId}",method = RequestMethod.GET)
    public Product getProductOne(
            @PathVariable int productId
    ) {

        Product productOne = productRepository.findByProductId(productId);

        return productOne;
    }



}
