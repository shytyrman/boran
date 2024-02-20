package com.example.boran.model;

import jakarta.persistence.Entity;
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Enter login!")
    @NotNull(message = "login can't be empty!")
    @Column(nullable = false, unique = true)
    @Column(name = "login")
    private String login;

    @NotBlank(message = "Enter password!")
    @NotNull(message = "Password can't be empty!")
    @Column(nullable = false)
    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @NotBlank(message = "Enter phone number!")
    @NotNull(message = "Phone number can't be empty!")
    @Column(nullable = false, unique = true)
    @Column(name = "phonenumber")
    private String phonenumber;

    @Column(name = "wallet")
    private String wallet;

    public User() {

    }

    public User(String login, String password, String fullname, String phonenumber, String wallet) {

    }
}
