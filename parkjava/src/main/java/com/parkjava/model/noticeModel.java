package com.parkjava.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "notice")
public class noticeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeIndex;
    private Integer adminIndex;
    private String adminName;
    private String noticeTitle;
    private String noticeContent;
    private Integer noticeView;
    private String createDate;
    private String updateDate;

}