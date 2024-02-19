package com.thomas.ikea2.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne(mappedBy = "product")
    private CategoryTextiles categoryTextiles;

    public CategoryTextiles getCategoryTextiles() {
        return categoryTextiles;
    }

    public void setCategoryTextiles(CategoryTextiles categoryTextiles) {
        this.categoryTextiles = categoryTextiles;
    }

    public CategoryFurniture getCategoryFurniture() {
        return categoryFurniture;
    }

    public void setCategoryFurniture(CategoryFurniture categoryFurniture) {
        this.categoryFurniture = categoryFurniture;
    }

    public CategoryFood getCategoryFood() {
        return categoryFood;
    }

    public void setCategoryFood(CategoryFood categoryFood) {
        this.categoryFood = categoryFood;
    }

    @OneToOne(mappedBy = "product")
    private CategoryFurniture categoryFurniture;

    @OneToOne(mappedBy = "product")
    private CategoryFood categoryFood;

    private String description;

    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @ManyToMany(mappedBy = "productSet")
    Set<Order> orderSet = new HashSet<>();

    public Product(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
