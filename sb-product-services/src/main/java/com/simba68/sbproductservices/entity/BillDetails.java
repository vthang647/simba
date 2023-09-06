package com.simba68.sbproductservices.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bill_details", schema = "sbmaster")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class BillDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    @Column(name = "bill_id")
    private String billId;
    @Column(name = "amount")
    private double amount;
    @Column(name = "food_id")
    private int food_id;
    @Column(name = "drink_id")
    private int drink_id;
    @Column(name = "cue_id")
    private int cue_id;
    @Column(name = "table_id")
    private int table_id;
    @Column(name = "combo_id")
    private int combo_id;
    @Column(name = "status")
    private String status;
    @Column(name = "end_timestamp")
    private LocalDateTime endTimestamp;
}
