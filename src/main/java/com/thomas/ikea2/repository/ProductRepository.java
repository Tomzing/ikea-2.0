package com.thomas.ikea2.repository;

import com.thomas.ikea2.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}