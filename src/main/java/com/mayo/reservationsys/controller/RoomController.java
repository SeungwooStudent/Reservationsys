package com.mayo.reservationsys.controller;

import com.mayo.reservationsys.entity.Reservation;
import com.mayo.reservationsys.entity.Room;
import com.mayo.reservationsys.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class RoomController {
    private final RoomService roomService;

    @GetMapping("/v1/roominfor/all")
    public List<Room> getRoominfor() {
        System.out.println("v1/roominfor/all");
        return roomService.getRoominfor();
    }
}
