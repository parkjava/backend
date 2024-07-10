package com.parkjava.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "penalty")
public class penaltyModel {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long penaltyIndex;
    private String imageUrl;
    private String carNumber;
    private String penaltyCash;
    private Date fineDate;
}