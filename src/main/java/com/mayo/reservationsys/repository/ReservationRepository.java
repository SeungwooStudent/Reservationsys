package com.mayo.reservationsys.repository;

import com.mayo.reservationsys.entity.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservations, Integer> {


    //예약취소
    @Modifying //수정,삭제시에 꼭 필요하다. 조회를 제외하고 변경이 일어나면 필요함
    @Query("DELETE FROM Reservations reservations Where reservations.reservationSeq = :id")
    int reservationCancel(int id);

    //예약확인,검색
    @Query("SELECT reservations FROM Reservations reservations Where reservations.userName = :name and reservations.phoneNumber = :phoneNumber")
    List<Reservations> searchUser(String name, String phoneNumber);

    //예약정보 수정
    @Modifying
    @Query("UPDATE Reservations reservations SET reservations.userName = :name, reservations.phoneNumber = :phoneNumber, reservations.userCount = :count, reservations.service = :service WHERE reservations.reservationSeq = :id")
    int updateUser(int id, String name, String phoneNumber, int count, boolean service);


}
