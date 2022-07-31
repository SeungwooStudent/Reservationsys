package com.mayo.reservationsys.dto.reservations;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;


public interface ReservationInfoDto {

    @ApiModelProperty(value="예약자의 예약고유 번호", dataType = "Long", required = true, example = "1")
    public Long getReservationSeq();

    @ApiModelProperty(value="예약자이름", dataType = "String", required = true, example = "홍길동")
    public String getUserName(); // userName

    @ApiModelProperty(value="예약자 전화번호", dataType = "String", required = true, example = "010-1234-5678")
    public String getPhoneNumber();

    @ApiModelProperty(value="방문 인원수", dataType = "String", required = true, example = "10")
    public String getUserCount();

    @ApiModelProperty(value="바베큐서비스", dataType = "boolean", required = true, example = "true")
    public boolean getService();

    @ApiModelProperty(value="체크인날짜", dataType = "Date", required = true, example = "2022-07-31")
    public Date getCheckIn();

    @ApiModelProperty(value="체크아웃날짜", dataType = "Date", required = true, example = "2022-08-01")
    public Date getCheckOut();

    @ApiModelProperty(value="방번호", dataType = "String", required = true, example = "1001")
    public String getRoomName(); // roomName


}
