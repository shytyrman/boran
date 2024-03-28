package com.example.boran.model;

import com.example.boran.authentication.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode
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

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    private Boolean nonLocked = true;
    private Boolean enabled = true;

    public User() {

    }

    public User(String login, String password, String fullname, String phonenumber, String wallet) {
        this.login = login;
        this.password = password;
        this.fullname = fullname;
        this.phoneNumber = phonenumber;
        this.wallet = wallet;
    }
}
