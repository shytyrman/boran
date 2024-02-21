package com.example.boran.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Enter login!")
    @NotNull(message = "login can't be empty!")
    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @NotBlank(message = "Enter password!")
    @NotNull(message = "Password can't be empty!")
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @NotBlank(message = "Enter phone number!")
    @NotNull(message = "Phone number can't be empty!")
    @Column(name = "phonenumber", nullable = false, unique = true)
    private String phonenumber;

    @Column(name = "wallet")
    private String wallet;

    public User() {

    }

    public User(String login, String password, String fullname, String phonenumber, String wallet) {

    }
}
