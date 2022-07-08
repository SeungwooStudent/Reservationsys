package com.mayo.reservationsys.repository;


import com.mayo.reservationsys.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, String> {

}
