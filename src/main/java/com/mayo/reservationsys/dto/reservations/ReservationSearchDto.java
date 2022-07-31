package com.mayo.reservationsys.dto.reservations;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)// room_no -> roomNo
public class ReservationSearchDto {

    @ApiModelProperty(value="예약자이름", dataType = "String", required = true, example = "홍길동")
    private String userName;

    @ApiModelProperty(value="예약자 전화번호", dataType = "String", required = true, example = "010-1234-5678")
    private String phoneNumber;

}
