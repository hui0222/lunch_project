package com.example.jpa.controller;

import com.example.jpa.domain.Product;
import com.example.jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    ProductService productService;


    @RequestMapping(path = "/product/list",method = RequestMethod.GET)
    public List<Product> getProductList() {

        List<Product> productList = productService.findAll();

        return productList;
    }




}
