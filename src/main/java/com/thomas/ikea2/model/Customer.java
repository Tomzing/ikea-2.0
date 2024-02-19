package com.thomas.ikea2.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "customer")
public class Customer {
    public Customer() {

    }

    @Id
    private UUID id = java.util.UUID.randomUUID();

    private String name;

    private String email;

    private String password;

    @Column(name="is_member")
    private boolean isMember;

    @Column(name="last_login")
    private Date lastLogin = new Date();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<Order> customerOrders;
}
