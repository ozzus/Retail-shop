package com.example.Retail_shop.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user", schema = "public",catalog = "Retail")
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "userd_id")
    private long userdId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password_hash")
    private String userPasswordHash;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "first_name")
    private String userFirstName;
    @Column(name = "last_name")
    private String userLastName;
}
