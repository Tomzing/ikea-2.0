package com.thomas.ikea2.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Table(name = "customer")
public class Customer {
    @Id
    private UUID id = java.util.UUID.randomUUID();



}
