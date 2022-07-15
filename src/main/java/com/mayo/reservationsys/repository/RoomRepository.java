package com.mayo.reservationsys.repository;


import com.mayo.reservationsys.entity.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Rooms, String> {

}
