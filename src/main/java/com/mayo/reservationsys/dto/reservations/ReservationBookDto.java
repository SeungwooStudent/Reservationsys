package com.mayo.reservationsys.dto.reservations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)// room_no -> roomNo
public class ReservationBookDto {

    @ApiModelProperty(value="방번호", dataType = "Integer", required = true, example = "1001")
    private int roomNo;

    @ApiModelProperty(value="예약자 이름", dataType = "String", required = true, example = "홍길동")
    private String userName;

    @ApiModelProperty(value="예약자 전화번호", dataType = "String", required = true, example = "010-9999-8888")
    private String phoneNumber;

    @ApiModelProperty(value="입실 인원수", dataType = "Integer", required = true, example = "10")
    private int userCount;

    @ApiModelProperty(value="체크인날짜", dataType = "Date", required = true, example = "2022-07-29")
    private Date checkIn;

    @ApiModelProperty(value="체크아웃날짜", dataType = "Date", required = true, example = "2022-07-30")
    private Date checkOut;

    @ApiModelProperty(value="바베큐서비스", dataType = "boolean", required = true, example = "true")
    private boolean service;
}
