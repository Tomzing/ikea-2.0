package com.thomas.ikea2.controller;

import com.thomas.ikea2.model.Order;
import com.thomas.ikea2.service.OrderService;
import com.thomas.ikea2.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Order getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @PostMapping(value = "/createOrder", consumes = "application/json", produces = "application/json")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

}
