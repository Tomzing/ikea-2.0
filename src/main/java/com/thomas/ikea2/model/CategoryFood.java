package com.thomas.ikea2.model;

import jakarta.persistence.*;

@Entity
public class CategoryFood {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String flavor;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="product_id")
    private Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public CategoryFood(String flavor, Product product) {
        this.flavor = flavor;
        this.product = product;
    }
}
