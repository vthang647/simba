package com.simba68.sbproductservices.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.*;

@Entity
@Table(name = "beverage", schema = "sbmaster")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Beverage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    @Column(name = "drink_name")
    private String drinkName;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private double price;

    public Long getId() {
        return id;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
