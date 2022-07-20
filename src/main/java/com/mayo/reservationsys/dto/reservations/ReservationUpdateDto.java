package com.mayo.reservationsys.dto.reservations;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)// room_no -> roomNo
public class ReservationUpdateDto {

//    private Long id;
    private String userName;
    private String phoneNumber;
    private int userCount;
    private boolean service;

}
