package com.example.boran.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "minibutches")
public class MiniButch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "day", nullable = false)
    private Timestamp day;

}
