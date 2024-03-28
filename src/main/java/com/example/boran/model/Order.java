package com.example.boran.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.sql.Date;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {


    private String userPhoneNumber;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "time")
    private Timestamp time;

    @Column(name = "jpid")
    private String jpid;

    @Column(name = "track")
    private String track;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userid")
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

    @Column(name = "day", nullable = false)
    private Date day;

    public Order() {

    }

    public Order(String track, String jpid, String userPhoneNumber, float weight, Date day) {
        this.track = track;
        this.jpid = jpid;
        this.weight = weight;
        this.day = day;
        this.userPhoneNumber = userPhoneNumber;
    }

    public Order(String track, String jpid, User userId, float weight, Date day, String place) {
        this.track = track;
        this.jpid = jpid;
        this.weight = weight;
        this.day = day;
        this.userId = userId;
        this.place = place;
    }
}