package com.mayo.reservationsys.dto.reservations;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;


public interface ReservationInfoDto {
    public String getReservationSeq();

    public String getUserName(); // userName

    public String getPhoneNumber();

    public String getUserCount();

    public boolean getService();

    public Date getCheckIn();

    public Date getCheckOut();

    public String getRoomName(); // roomName


}
