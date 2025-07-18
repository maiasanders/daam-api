package com.daam.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private int id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "FIRST")
    private String first;

    @Column(name = "LAST")
    private String last;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Column(name = "PAN")
    private String pan;

    @Column(name = "EXPIRY_MONTH")
    private int expiryMonth;

    @Column(name = "EXPIRY_YEAR")
    private int expiryYear;

    @Column(name = "ROLES")
    private String roles;

}
