package com.mayo.reservationsys.controller;

import com.mayo.reservationsys.dto.reservations.*;
import com.mayo.reservationsys.entity.Reservations;
import com.mayo.reservationsys.service.ReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/reservation")
@Api(tags = {"펜션 예약 "})
public class ReservationController {
    // java
    // class = field + method

    // objected-oriented
    // class = state + behavior(operation)
    private static final String RESERVATION_API = "v1/reservation";

    private final ReservationService reservationService;

    @GetMapping("all")
    @ApiOperation(value = "모든예약조회", notes = "모든 예약에 대한 정보를 가져오는 api 입니다.")
    public List<ReservationInfoDto> getReservations() {
        System.out.println(RESERVATION_API + "/all");
        return reservationService.getReservations();
    }

    @PostMapping("book")
    @ApiOperation(value = "예약하기", notes = "펜션예약을 하는 api 입니다.")
    // dto -> data transfer object
    public String reservation(@Valid @RequestBody ReservationBookDto reservationBookDto) {
        System.out.println(RESERVATION_API + "/book");
        return reservationService.book(reservationBookDto);
    }

    @PostMapping("cancel/{seq}")
    @ApiOperation(value = "예약취소", notes = "예약자의 예약 고유번호로 예약 취소를 할수있는 api 입니다.")
    public String reservationCancel(@ApiParam(
            name = "seq",
            type = "integer",
            value = "예약자의 고유번호",
            example = "5",
            required = true)
            @PathVariable Long seq) {
        System.out.println(RESERVATION_API + "/cancel/" + seq);
        return reservationService.reservationCancel(seq);
    }

//    @GetMapping("search")
    @GetMapping("search")
    @ApiOperation(value = "예약조회", notes = "예약자의 이름,전화번호로 예약정보를 조회할수있는 api 입니다.")
    public List<Reservations> searchUser(@RequestBody ReservationSearchDto reservationSearchDto) {
        System.out.println(RESERVATION_API + "/search");
        return reservationService.reservationSearch(reservationSearchDto);
    }

    @PostMapping("update/{id}")
    @ApiOperation(value = "예약수정", notes = "예약자의 예약 고유번호로 이름,전화번호,인원수,서비스를 수정할수 있는 api 입니다.")
    public String reservationUpdate(@ApiParam(
            name = "id",
            value = "예약자의 예약고유번호",
            example = "1",
            required = true)
            @PathVariable Long id, @RequestBody ReservationUpdateDto reservationUpdateDto) {
        System.out.println(RESERVATION_API + "/update/");
        return reservationService.updateUser(id, reservationUpdateDto);
    }

    @GetMapping("available_rooms") // localhost:8080/v1/reservation/available_rooms/2022-01-01
    @ApiOperation(value = "빈방조회", notes = "특정한 날짜에 예약이 가능한 방을 조회할수 있는 api 입니다.")
    public List<ReservationCheckDto> availableRooms(@ApiParam(
            name = "date",
            type = "String",
            value = "예약을 원하는 날짜",
            example = "2022-07-31",
            required = true)
            @RequestParam("date") String date) throws ParseException {
        System.out.println(RESERVATION_API + "/available_rooms/" + date);
        return reservationService.availableRooms(date);
    }

    @GetMapping("available_rooms_month") // localhost:8080/v1/reservation/available_rooms/2022-01-01
    @ApiOperation(value = "빈방조회", notes = "특정한 월에 예약이 가능한 방을 조회할수 있는 api 입니다.")
    public List<ReservationCheckDto> availableRoomsForMonth(@ApiParam(
            name = "date",
            type = "String",
            value = "예약을 원하는 달",
            example = "2022-08-01",
            required = true)
            @RequestParam("date") String date) throws ParseException {
        System.out.println(RESERVATION_API + "/available_rooms_month/" + date);
        return reservationService.availableRoomsForMonth(date);
    }
    
    //핸드폰번호로 조회
    @GetMapping("phone_number_search")
    @ApiOperation(value = "예약자 전화번호로 에약조회", notes = "예약자의 전화번호로 예약정보를 조회할수 있는 api 입니다.")
    public List<Reservations> phoneNumberSearch(@ApiParam(
            name = "phoneNumber",
            type = "String",
            value = "예약자의 전화번호",
            example = "010-1234-5678",
            required = true)
            @RequestParam("phoneNumber") String phoneNumber) {
        System.out.println(RESERVATION_API + "/phone_number_search/");
        return reservationService.phoneNumberSearch(phoneNumber);
    }

    //방 번호로 예약조회
    @GetMapping("room_number_search")
    @ApiOperation(value = "예약한 방 번호로 예약조회", notes = "예약자가 예약한 방의 호수로 예약정보를 조회할수 있는 api 입니다.")
    public List<Reservations> roomNumberSearch(@ApiParam(
            name = "roomNo",
            type = "Integer",
            value = "예약자의 방의 호수",
            example = "1001",
            required = true)
            @RequestParam("roomNo") int roomNo) {
        System.out.println(RESERVATION_API + "/room_number_search/");
        return reservationService.roomNumberSearch(roomNo);
    }

    //날짜로 예약조회
    @GetMapping("date_search")
    @ApiOperation(value = "체크인 날짜로 예약조회", notes = "예약자의 체크인 날짜로 예약정보를 조회할수 있는 api 입니다.")
    public List<Reservations> dateSearch(@ApiParam(
            name = "date",
            type = "String",
            value = "체크인 날짜",
            example = "2022-01-01",
            required = true)
        @RequestParam("date") String date) throws ParseException {
        System.out.println(RESERVATION_API + "/date_search/" + date);
        return reservationService.dateSearch(date);
    }


}
