package com.simba68.sbproductservices.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bill", schema = "sbmaster")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    @Column(name = "bill_name")
    private String billName;
    @Column(name = "amount")
    private double amount;
    @Column(name = "status")
    private String status;
    @Column(name = "end_timestamp")
    private LocalDateTime endTimestamp;
}
