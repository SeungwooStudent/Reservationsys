package com.mayo.reservationsys.controller;

import com.mayo.reservationsys.entity.Rooms;
import com.mayo.reservationsys.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/room")
public class RoomController {
    private final String API_NAME = "v1/room";
    private final RoomService roomService;

    @GetMapping("info/all")
    public List<Rooms> getRoomInfo() {
        System.out.println(API_NAME + "info/all");
        return roomService.getRoomInfo();
    }
}
