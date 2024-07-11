package com.parkjava.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "patrol")
public class patrolModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patrol_index;
    @Column(name = "user_name", nullable = false,length = 200)
    private String user_name;
    @Column(name = "patrol_area", nullable = false,length = 200)
    private String patrol_area;
    @Column(name = "patrol_summary", nullable = false,length = 200)
    private String patrol_summary;
    @Column(name = "create_date", nullable = false,length = 200)
    private String create_date;
    @Column(name = "update_date", nullable = false,length = 200)
    private String update_date;


    @ManyToOne
    @JoinColumn(name = "user_index")
    private usersModel users;
}


