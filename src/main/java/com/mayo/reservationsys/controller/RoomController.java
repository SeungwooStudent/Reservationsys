package com.mayo.reservationsys.controller;

import com.mayo.reservationsys.entity.Rooms;
import com.mayo.reservationsys.service.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/room")
@Api(tags = {"펜션 방 정보"})
public class RoomController {
    private final String API_NAME = "v1/room";
    private final RoomService roomService;

    @GetMapping("info/all")
    @ApiOperation(value = "모든 방 조회", notes = "펜션내에 모든 방에 대한 정보를 가져오는 api 입니다.")
    public List<Rooms> getRoomInfo() {
        System.out.println(API_NAME + "info/all");
        return roomService.getRoomInfo();
    }
}
