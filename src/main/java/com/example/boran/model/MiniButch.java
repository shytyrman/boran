package com.example.boran.model;

import jakarta.persistence.Entity;
@Entity
@Table(name = "minibutches")
public class MiniButch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    @Column(name = "day")
    private Timestamp day;
}
