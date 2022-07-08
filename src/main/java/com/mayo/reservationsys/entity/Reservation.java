package com.mayo.reservationsys.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor //모든 필드값을 파라미터로 받는 생성자
@NoArgsConstructor //파라미터가 없는 기본 생성자
public class Reservation {
    @Id
    private int id;
    private int roomNo;
    private String name;
    private String phoneNumber;
    private int count;
    private Date startDate;
    private Date endDate;
    private boolean service;

}
