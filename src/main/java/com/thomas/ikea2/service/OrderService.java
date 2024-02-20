package com.thomas.ikea2.service;

import com.thomas.ikea2.interfaces.OrderServiceInterface;
import com.thomas.ikea2.model.Order;
import com.thomas.ikea2.model.Product;
import com.thomas.ikea2.repository.OrderRepository;
import com.thomas.ikea2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        Optional<Order> order = orderRepository.findById(id);

        float orderTotal  = 0;

        for(int i = 0; i < order.get().getProductList().size(); i++) {
            System.out.println("Item: " + order.get().getProductList().get(i).getName()
            + " - Price " + order.get().getProductList().get(i).getPrice());
            orderTotal += order.get().getProductList().get(i).getPrice();
        }
        System.out.println("Total price: " + orderTotal);


        //Vet at get callet failer på serialisering til json, println returnerer riktig :)
        Optional<Order> optionalOrder = orderRepository.findById(id);
        optionalOrder.get().setOrderTotal(orderTotal);
        return optionalOrder.orElse(null);
    }

    @Override
    public Order createOrder(Order order) {

        //Ordre blir laget, men desverre ikke helt riktig

        /*order.getProductList().get(0).getId();
        Iterator<Product> i = order.getProductList().iterator();
        while (i.hasNext()) {
            System.out.println("ID? " + i.next().getId());
            Optional<Product> tempProduct = productRepository.findById(i.next().getId());
            System.out.println(tempProduct);
            order.getProductList().add(tempProduct.get());
        }*/

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }
}
