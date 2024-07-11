//package com.parkjava.model;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Setter
//@Getter
//@Entity
//@Table(name = "penalty")
//public class penaltyModel {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long penalty_index;
//    @Column(name = "image_url", nullable = false, length = 200)
//    private String image_url;
//    @Column(name = "car_number", nullable = false, length = 200)
//    private String car_number;
//    @Column(name = "penalty_cash", nullable = false, length = 200)
//    private String penalty_cash;
//    @Column(name = "fine_date", nullable = false, length = 200)
//    private String fine_date;
//
//    // Getters and Setters
//
//}