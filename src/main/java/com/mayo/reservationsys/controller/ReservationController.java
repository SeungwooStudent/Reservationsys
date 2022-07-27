package com.mayo.reservationsys.controller;

import com.mayo.reservationsys.dto.reservations.*;
import com.mayo.reservationsys.entity.Reservations;
import com.mayo.reservationsys.service.ReservationService;
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
public class ReservationController {
    private static final String RESERVATION_API = "v1/reservation";

    private final ReservationService reservationService;

    @GetMapping("all")
    public List<ReservationInfoDto> getReservations() {
        System.out.println(RESERVATION_API + "/all");
        return reservationService.getReservations();
    }

    @PostMapping("book")
    // dto -> data transfer object
    public String reservation(@Valid @RequestBody ReservationBookDto reservationBookDto) {
        System.out.println(RESERVATION_API + "/book");
        return reservationService.book(reservationBookDto);
    }

    @PostMapping("cancle/{seq}")
    public String reservationCancle(@PathVariable Long seq) {
        System.out.println(RESERVATION_API + "/cancle/" + seq);
        return reservationService.reservationCancle(seq);
    }

    @GetMapping("search")
    public List<Reservations> searchUser(@RequestBody ReservationSearchDto reservationSearchDto) {
        System.out.println(RESERVATION_API + "/search");
        return reservationService.reservationSearch(reservationSearchDto);
    }

    @PostMapping("update/{id}")
    public String reservationUpdate(@PathVariable Long id, @RequestBody ReservationUpdateDto reservationUpdateDto) {
        System.out.println(RESERVATION_API + "/update/");
        return reservationService.updateUser(id, reservationUpdateDto);
    }

    @GetMapping("avaliable_rooms") // localhost:8080/v1/reservation/avaliable_rooms/2022-01-01
    public List<ReservationCheckDto> avaliableRooms(@RequestParam("date") String date) throws ParseException {
        System.out.println(RESERVATION_API + "/avaliable_rooms/" + date);
        return reservationService.avaliableRooms(date);
    }
    
    //핸드폰번호로 조회
    @GetMapping("phone_number_search")
    public List<Reservations> phoneNumberSearch(@RequestParam("phoneNumber") String phoneNumber) {
        System.out.println(RESERVATION_API + "/phone_number_search/");
        return reservationService.phoneNumberSearch(phoneNumber);
    }

    //방 번호로 예약조회
    @GetMapping("room_number_search")
    public List<Reservations> roomNumberSearch(@RequestParam("roomNo") int roomNo) {
        System.out.println(RESERVATION_API + "/room_number_search/");
        return reservationService.roomNumberSearch(roomNo);
    }


}
