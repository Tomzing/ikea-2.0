package com.thomas.ikea2.model;

import jakarta.persistence.*;

@Entity
@Table(name="category_textiles")
public class CategoryTextiles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int item_number;

    private String color;


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="product_id", referencedColumnName = "id")
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

    public void setItemNumber(int itemNumber) {
        this.item_number = itemNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public CategoryTextiles(int itemNumber, String color, Product product) {
        this.item_number = itemNumber;
        this.color = color;
        this.product = product;
    }

    public CategoryTextiles() {
        super();
    }


}
