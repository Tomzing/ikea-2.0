package com.thomas.ikea2.repository;

import com.thomas.ikea2.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
