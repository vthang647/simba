package com.simba68.sbproductservices.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.*;

@Entity
@Table(name = "combo", schema = "sbmaster")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Combo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    @Column(name = "combo_name")
    private String comboName;
    @Column(name = "food_id")
    private int foodId;
    @Column(name = "drink_id")
    private int drinkId;
    @Column(name = "cue_id")
    private int cueId;
    @Column(name = "table_id")
    private int tableId;
    @Column(name = "quantity")
    private int quantity;
}
