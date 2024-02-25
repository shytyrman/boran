package com.example.boran.model;

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
    @Column(name = "phonenumber", unique = true)
    private String phoneNumber;

    @Column(name = "wallet")
    private String wallet;

    public User() {

    }

    public User(String login, String password, String fullname, String phonenumber, String wallet) {
        this.login = login;
        this.password = password;
        this.fullname = fullname;
        this.phoneNumber = phonenumber;
        this.wallet = wallet;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
