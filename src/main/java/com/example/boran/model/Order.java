package com.example.boran.model;

import jakarta.persistence.Entity;
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    @Column(name = "day")
    private Timestamp time;

    @Column(name = "jpid")
    private String jpid;

    @Column(name = "track")
    private String track;

    @Column(name = "userid")
    private long userid;

    @Column(name = "weight")
    private float weight;

    @Column(name = "kgprice")
    private float kgprice;

    @Column(name = "place")
    private String place;

    @Column(name = "boxnum")
    private int boxnum;

    @Column(name = "cost")
    private float cost;

    @Column(name = "status")
    private String status;

    @Column(name = "minibutchid")
    private long minibutchid;
}
