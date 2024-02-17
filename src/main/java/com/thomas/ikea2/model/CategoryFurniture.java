package com.thomas.ikea2.model;

import jakarta.persistence.*;

@Entity
public class CategoryFurniture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int item_number;


    private float weight;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="product_id")
    private Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemNumber() {
        return item_number;
    }

    public void setItemNumber(int item_number) {
        this.item_number = item_number;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public CategoryFurniture(int itemNumber, float weight, Product product) {
        this.item_number = itemNumber;
        this.weight = weight;
        this.product = product;
    }

    public CategoryFurniture() {
        super();
    }
}
