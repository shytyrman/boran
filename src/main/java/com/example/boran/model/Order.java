package com.example.boran.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "day", nullable = false)
    private Timestamp time;

    @Column(name = "jpid")
    private String jpid;

    @Column(name = "track")
    private String track;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "id")
    @Column(name = "userid")
    private User userId;

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

    @ManyToOne(targetEntity = MiniButch.class)
    @JoinColumn(name = "id")
    @Column(name = "minibutchid")
    private MiniButch minibutchid;
}
