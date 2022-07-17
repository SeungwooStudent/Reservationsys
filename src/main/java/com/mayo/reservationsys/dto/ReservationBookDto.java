package com.mayo.reservationsys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)// room_no -> roomNo
public class ReservationBookDto {

    private int roomNo;
    private String userName;
    private String phoneNumber;
    private int userCount;
    private Date check_in;
    private Date check_out;
    private boolean service;
}
