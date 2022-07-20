package com.mayo.reservationsys.controller;

import com.mayo.reservationsys.dto.reservations.ReservationBookDto;
import com.mayo.reservationsys.dto.reservations.ReservationSearchDto;
import com.mayo.reservationsys.dto.reservations.ReservationUpdateDto;
import com.mayo.reservationsys.dto.reservations.ReservationInfoDto;
import com.mayo.reservationsys.entity.Reservations;
import com.mayo.reservationsys.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
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
    public String reservationUpdate(@PathVariable Long id ,@RequestBody ReservationUpdateDto reservationUpdateDto) {
        System.out.println(RESERVATION_API + "/update/");
        return reservationService.updateUser(id,reservationUpdateDto);
    }
}
