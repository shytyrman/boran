package com.example.boran.model;

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

    public Currency() {

    }

    public Currency(Timestamp day, BigDecimal dollar) {
        this.id = id;
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
