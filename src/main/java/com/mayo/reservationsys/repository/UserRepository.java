package com.mayo.reservationsys.repository;

import com.mayo.reservationsys.entity.Reservation;
import com.mayo.reservationsys.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT user FROM User user Where user.id = :id")
    User findUserById(String id);
}
