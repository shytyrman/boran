package com.example.boran.model;

import jakarta.persistence.Entity;
@Entity
@Table(name = "currency")
public class Currency {

    @Column(nullable = false)
    @Column(name = "day")
    private Timestamp day;


    @Column(nullable = false)
    @Column(name = "login")
    private float dollar;
}
