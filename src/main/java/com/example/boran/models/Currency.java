package com.example.boran.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "currency")
public class Currency {

    @Id
    private Long id;

    @Column(name = "day", nullable = false)
    private Timestamp day;


    @Column(name = "usdPrice", nullable = false)
    private BigDecimal dollar;
}
