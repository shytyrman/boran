package com.example.boran.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "currency")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "day", nullable = false)
    private Timestamp day;


    @Column(name = "usdPrice", nullable = false)
    private BigDecimal dollar;

    public Currency() {

    }

    public Currency(Timestamp day, BigDecimal dollar) {
        this.day = day;
        this.dollar = dollar;
    }

    public void setDollar(BigDecimal dollar) {
        this.dollar = dollar;
    }

    public void setDay(Timestamp day) {
        this.day = day;
    }

    public BigDecimal getDollar() {
        return dollar;
    }

    public Timestamp getDay() {
        return day;
    }

    public long getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Currency [day=" + day + ", dollar=" + dollar + "]";
    }
}
