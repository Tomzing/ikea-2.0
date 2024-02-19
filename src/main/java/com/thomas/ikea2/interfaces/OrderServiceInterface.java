package com.thomas.ikea2.interfaces;

import com.thomas.ikea2.model.Order;

public interface OrderServiceInterface {
    //Get order by ID
    Order getOrderById(int id);
    //Create a new order
    Order createOrder(Order order);
}
