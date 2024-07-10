package com.parkjava.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "patrol")
public class patrolModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patrolIndex;
    private Integer userIndex;
    private String userName;
    private String patrolArea;
    private String patrolSummary;
    private String createDate;
    private String updateDate;

}