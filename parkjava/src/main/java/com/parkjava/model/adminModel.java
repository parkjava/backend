package com.parkjava.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "park_java_admin")
public class adminModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminIndex;
    private String adminName;
    private String adminId;
    private String adminPassword;


    // Getters and Setters

}