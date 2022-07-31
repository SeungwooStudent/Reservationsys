package com.mayo.reservationsys.dto.reservations;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)// room_no -> roomNo
public class ReservationUpdateDto {

//    private Long id;
    @ApiModelProperty(value="예약자이름", dataType = "String", required = true, example = "홍길동")
    private String userName;

    @ApiModelProperty(value="예약자 전화번호", dataType = "String", required = true, example = "010-1234-5678")
    private String phoneNumber;

    @ApiModelProperty(value="방문 인원수", dataType = "Integer", required = true, example = "10")
    private int userCount;

    @ApiModelProperty(value="바베큐서비스", dataType = "boolean", required = true, example = "true")
    private boolean service;

}
