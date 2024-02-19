package com.thomas.ikea2.controller;

import com.thomas.ikea2.model.Product;
import com.thomas.ikea2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;


    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }
}
