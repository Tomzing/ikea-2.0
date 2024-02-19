package com.thomas.ikea2.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    public Order() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductSet(List<Product> productList) {
        this.productList = productList;
    }

    public float getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(float orderTotal) {
        this.orderTotal = orderTotal;
    }

    @Column(name = "order_total")
    private float orderTotal = 0;

    @Column(name = "order_date")
    private Date date = new Date();



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "products_ordered",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    List<Product> productList = new ArrayList<>();





}
