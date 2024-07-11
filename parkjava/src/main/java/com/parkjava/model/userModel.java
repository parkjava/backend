package com.parkjava.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "users")
public class userModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userIndex;
    private String userName;
    private String userId;
    private String userPw;

    // Getters and Setters

}