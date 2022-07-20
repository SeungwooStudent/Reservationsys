package com.mayo.reservationsys.dto.reservations;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)// room_no -> roomNo
public class ReservationSearchDto {

    private String userName;
    private String phoneNumber;

//    @Builder
//    public ReservationSearchDto(String userName, String phoneNumber) {
//        this.userName = userName;
//        this.phoneNumber = phoneNumber;
//    }

}
