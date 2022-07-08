package com.mayo.reservationsys.controller;

import com.mayo.reservationsys.entity.Reservation;
import com.mayo.reservationsys.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/reservation")
public class ReservationController {
    private static final String RESERVATION_API = "v1/reservation";

    private final ReservationService reservationService;

    @GetMapping("all")
    public List<Reservation> getReservations() {
        System.out.println(RESERVATION_API + "/all");
        return reservationService.getReservations();
    }

    @PostMapping("book")
    public String reservation(@RequestParam("roomNo") int roomNo, @RequestParam("name") String name, @RequestParam("phoneNumber") String phoneNumber, @RequestParam("count") int count, @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate, @RequestParam(name = "service",required = false) Boolean service) {
        System.out.println(RESERVATION_API + "/book");
        return reservationService.reservation(roomNo, name, phoneNumber, count, startDate, endDate, service);
    }

    @PostMapping("cancle")
    public String reservationCancel(@RequestParam("id") int id) {
        System.out.println(RESERVATION_API + "/cancle");
        return reservationService.reservationCancel(id);
    }

    @GetMapping("search")
    public List<Reservation> searchUser(@RequestParam("name") String name, @RequestParam("phoneNumber") String phoneNumber) {
        System.out.println(RESERVATION_API + "/search");
        return reservationService.reservationSearch(name , phoneNumber);
    }

    @PostMapping("update")
    public String reservationUpdate(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("phoneNumber") String phoneNumber, @RequestParam("count") int count, @RequestParam("service") boolean service) {
        return reservationService.updateUser(id, name, phoneNumber, count, service);
    }
}
