package com.mayo.reservationsys.controller;

import com.mayo.reservationsys.dto.ReservationBookDto;
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
    public List<Reservations> getReservations() {
        System.out.println(RESERVATION_API + "/all");
        return reservationService.getReservations();
    }

    @PostMapping("book")
    // dto -> data transfer object
    public String reservation(@Valid @RequestBody ReservationBookDto reservationBookDto) {
        System.out.println(RESERVATION_API + "/book");
        return reservationService.reservation(reservationBookDto);
    }

//    @PostMapping("cancel")
//    public String reservationCancel(@Valid @RequestBody ReservationCancelDto reservationCancelDto) {
//        System.out.println(RESERVATION_API + "/cancel");
//        return reservationService.reservationCancel(reservationCancelDto);
//    }

//    @GetMapping("search")
//    public List<Reservation> searchUser(@Valid @RequestBody ReservationSearchDto reservationSearchDto) {
//        System.out.println(RESERVATION_API + "/search");
//        return reservationService.reservationSearch(reservationSearchDto);
//    }

    @PostMapping("update")
    public String reservationUpdate(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("phoneNumber") String phoneNumber, @RequestParam("count") int count, @RequestParam("service") boolean service) {
        return reservationService.updateUser(id, name, phoneNumber, count, service);
    }
}
