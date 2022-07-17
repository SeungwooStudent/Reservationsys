package com.mayo.reservationsys.dto.reservations;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;


public interface ReservationInfoDto {
    public String getUserName(); // userName

    public String getPhoneNumber();

    public String getUserCount();

    public boolean getService();

    public Date getCheck_in();

    public Date getCheck_out();

    public String getRoomName(); // roomName


}
