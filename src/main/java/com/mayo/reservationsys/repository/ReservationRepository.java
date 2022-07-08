package com.mayo.reservationsys.repository;

import com.mayo.reservationsys.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {


    //예약취소
    @Modifying //수정,삭제시에 꼭 필요하다. 조회를 제외하고 변경이 일어나면 필요함
    @Query("DELETE FROM Reservation reservation Where reservation.id = :id")
    int reservationCancel(int id);

    //예약확인,검색
    @Query("SELECT reservation FROM Reservation reservation Where reservation.name = :name and reservation.phoneNumber = :phoneNumber")
    List<Reservation> searchUser(String name, String phoneNumber);

    //예약정보 수정
    @Modifying
    @Query("UPDATE Reservation reservation SET reservation.name = :name, reservation.phoneNumber = :phoneNumber, reservation.count = :count, reservation.service = :service WHERE reservation.id = :id")
    int updateUser(int id, String name, String phoneNumber, int count, boolean service);


}
