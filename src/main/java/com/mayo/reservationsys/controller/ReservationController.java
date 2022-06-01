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
@RequestMapping
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping("/v1/reservation/all")
    @CrossOrigin("*")
    public List<Reservation> getReservations() {
        System.out.println("v1/reservation/all");
        return reservationService.getReservations();
    }


    @CrossOrigin("*")
    @PostMapping("/reservation")
    public String reservation(@RequestParam("roomNo") int roomNo, @RequestParam("name") String name, @RequestParam("phoneNumber") String phoneNumber, @RequestParam("count") int count, @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate, @RequestParam(name = "service",required = false) Boolean service) {
        return reservationService.reservation(roomNo, name, phoneNumber, count, startDate, endDate, service);
    }

    @CrossOrigin("*")
    @PostMapping("/reservationCancel")
    public String reservationCancel(@RequestParam("id") int id) {
        return reservationService.reservationCancel(id);
    }

    @CrossOrigin("*")
    @GetMapping("/reservationSearch")
    public List<Reservation> searchUser(@RequestParam("name") String name, @RequestParam("phoneNumber") String phoneNumber) {
        return reservationService.reservationSearch(name , phoneNumber);
    }

//    @CrossOrigin("*")
//    @PostMapping("/reservationUpdate")
//    public String update(@RequestParam("name") String name, @RequestParam("phoneNumber") String phoneNumber, @RequestParam("count") int count, @RequestParam("service") boolean service) {
//        return reservationService.updateUser(name, phoneNumber, count, service);
//    }
}
