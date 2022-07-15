package com.mayo.reservationsys.service;

import com.mayo.reservationsys.entity.Rooms;
import com.mayo.reservationsys.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public List<Rooms> getRoomInfo() {
        return roomRepository.findAll();
    }

}
