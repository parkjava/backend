package com.parkjava.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "inquiry")
public class inquiryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inquiryIndex;
    private String inquiryTitle;
    private String inquiryWriter;
    private String inquiryContent;
    private String inquiryEmail;
    private String inquiryPhone;
    private Date inquiryDate;

}