package com.simba68.sbproductservices.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "table_billiard", schema = "sbmaster")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TableBilliard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    @Column(name = "table_name")
    private String tableName;
    @Column(name = "table_branch")
    private String tableBranch;
    @Column(name = "status")
    private String status;
}
