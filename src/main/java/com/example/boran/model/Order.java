package com.example.boran.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.sql.Timestamp;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Transient
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

    public Order() {

    }

    public Order(String track, String jpid, String userPhoneNumber, float weight, String place, String status) {
        this.track = track;
        this.jpid = jpid;
        this.weight = weight;
        this.userPhoneNumber = userPhoneNumber;
        this.boxnum = boxnum;
        this.place = place;
        this.status = status;
    }

    public Order(
            String track,
            String jpid,
            User userId,
            float weight,
            String place,
            int boxnum,
            Timestamp time,
            float cost,
            String status
    ) {
        this.track = track;
        this.jpid = jpid;
        this.weight = weight;
        this.userId = userId;
        this.place = place;
        this.boxnum = boxnum;
        this.time = time;
        this.cost = cost;
        this.status = status;
    }

    public Timestamp getTime() {
        return this.time;
    }

    public String getJPID() {
        return this.jpid;
    }

    public String getTrack() {
        return this.track;
    }

    public float getWeight() {
        return this.weight;
    }

    public String getUserPhoneNumber() {
        return this.userPhoneNumber;
    }

    public User getUserId() {
        return this.userId;
    }

    public String getPlace() {
        return this.place;
    }

    public int getBoxnum() {
        return this.boxnum;
    }

    public String getStatus() {
        return this.status;
    }

    public float getCost() {
        return this.cost;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}