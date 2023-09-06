package com.simba68.sbproductservices.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cue", schema = "sbmaster")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Cue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    @Column(name = "cue_name")
    private String cueName;
    @Column(name = "cue_type")
    private String cueType;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "create_timestamp")
    private LocalDateTime createTimestamp;
}
