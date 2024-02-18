package com.thomas.ikea2.controller;

import com.thomas.ikea2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

}
