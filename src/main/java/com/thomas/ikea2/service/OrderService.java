package com.thomas.ikea2.service;

import com.thomas.ikea2.interfaces.OrderServiceInterface;
import com.thomas.ikea2.model.Order;
import com.thomas.ikea2.model.Product;
import com.thomas.ikea2.repository.OrderRepository;
import com.thomas.ikea2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements OrderServiceInterface {

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    OrderRepository orderRepository;
    ProductRepository productRepository;

    @Override
    public Order getOrderById(int id) {

        Optional<Order> optionalOrder = orderRepository.findById(id);
        //System.out.println(optionalOrder.get().getId() + " skvoop " + optionalOrder.get().getProductSet());
        return optionalOrder.orElse(null);
    }

    @Override
    public Order createOrder(Order order) {

        Iterator<Product> i = order.getProductSet().iterator();
        while (i.hasNext()) {
            System.out.println("ID? " + i.next().getId());
            Optional<Product> tempProduct = productRepository.findById(i.next().getId());
            System.out.println(tempProduct);
            order.getProductSet().add(tempProduct.get());
        }

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }
}
