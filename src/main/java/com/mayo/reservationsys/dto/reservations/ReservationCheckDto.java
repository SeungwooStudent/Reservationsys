package com.mayo.reservationsys.dto.reservations;

import io.swagger.annotations.ApiModelProperty;

public interface ReservationCheckDto {

    @ApiModelProperty(value="방번호", dataType = "String", required = true, example = "1001")
    public String getRoomNo();
}
