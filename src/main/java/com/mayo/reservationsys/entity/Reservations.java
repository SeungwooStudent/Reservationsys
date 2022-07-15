package com.mayo.reservationsys.entity;

import com.mayo.reservationsys.entity.common.BaseTime;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor //모든 필드값을 파라미터로 받는 생성자
@NoArgsConstructor //파라미터가 없는 기본 생성자
public class Reservations extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reservationSeq;

    private int userCount;
    private String userName;
    private String phoneNumber;
    private int roomNo;
    private boolean service;
    private Date startDate;
    private Date endDate;

}
