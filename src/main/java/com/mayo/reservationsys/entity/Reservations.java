package com.mayo.reservationsys.entity;

import com.mayo.reservationsys.entity.common.BaseTime;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor //모든 필드값을 파라미터로 받는 생성자
@NoArgsConstructor //파라미터가 없는 기본 생성자
public class Reservations extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="예약자의 고유 ID", dataType = "Long", required = true, example = "1")
    private Long reservationSeq;

    @ApiModelProperty(value="입실 인원수", dataType = "Integer", required = true, example = "10")
    private int userCount;

    @ApiModelProperty(value="예약자이름", dataType = "String", required = true, example = "홍길동")
    private String userName;

    @ApiModelProperty(value="예약자 전화번호", dataType = "String", required = true, example = "010-1234-5678")
    private String phoneNumber;

    @ApiModelProperty(value="방번호", dataType = "String", required = true, example = "1001")
    private int roomNo;

    @ApiModelProperty(value="바베큐서비스", dataType = "boolean", required = true, example = "true")
    private boolean service;

    // req = 2022-01-15
    // req > check_in && req < check_out
    @ApiModelProperty(value="체크인날짜", dataType = "String", required = true, example = "2022-07-31")
    private String checkIn; // 2022-01-16

    @ApiModelProperty(value="체크아웃날짜", dataType = "String", required = true, example = "2022-08-01")
    private String checkOut;// 2022-01-17

}
