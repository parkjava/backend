package com.parkjava.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "users")
public class usersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_index;
    @Column(name = "user_name", nullable = false, length = 200)
    private String user_name;
    @Column(name = "user_pw", nullable = false, length = 200)
    private String user_pw;
    @Column(name = "user_id", nullable = false, length = 200)
    private String user_id;

    // Getters and Setters

}