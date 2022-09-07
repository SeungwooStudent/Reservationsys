package com.mayo.reservationsys.repository;

import com.mayo.reservationsys.dto.reservations.ReservationCheckDto;
import com.mayo.reservationsys.dto.reservations.ReservationInfoDto;
import com.mayo.reservationsys.entity.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservations, Long> {

    //예약취소
    @Modifying //수정,삭제시에 꼭 필요하다. 조회를 제외하고 변경이 일어나면 필요함
    @Query("DELETE FROM Reservations reservations Where reservations.reservationSeq = :id")
    int reservationCancel(long id);

    //예약확인,검색
    @Query("SELECT reservations FROM Reservations reservations Where reservations.userName = :name and reservations.phoneNumber = :phoneNumber")
    List<Reservations> searchUser(String name, String phoneNumber);

    //예약정보 수정
    @Modifying
    @Query("UPDATE Reservations reservations SET reservations.userName = :name, reservations.phoneNumber = :phoneNumber, reservations.userCount = :count, reservations.service = :service WHERE reservations.reservationSeq = :id")
    int updateUser(long id, String name, String phoneNumber, int count, boolean service);
    
    //예약조회시 필요한정보만 보여주기
    @Query("SELECT re.reservationSeq AS reservationSeq, re.userName AS userName, r.roomName AS roomName, re.phoneNumber AS phoneNumber, re.userCount AS userCount, re.service AS service, re.checkIn AS checkIn, re.checkOut AS checkOut from Reservations re INNER JOIN Rooms r ON re.roomNo = r.roomNo")
    List<ReservationInfoDto> findReservations();

    //특정날짜로 예약가능한 방 조회
    //
    //SELECT rooms.room_no as roomNo FROM Rooms rooms WHERE rooms.room_no NOT IN (SELECT r.room_no FROM Reservations r where "2022-08-10" >= r.check_in AND "2022-08-10" <= r.check_out)
    @Query("SELECT rooms.roomNo as roomNo FROM Rooms rooms WHERE rooms.roomNo NOT IN (SELECT r.roomNo FROM Reservations r where :requestDate >= r.checkIn AND :requestDate <= r.checkOut)")
    List<ReservationCheckDto> getAvailableRooms(String requestDate);

    //SELECT re FROM Reservationsys re WHERE re.check_in >= "2022-08-01" AND re.checkout <= "2022-08-31";
    @Query("SELECT re FROM Reservations re WHERE re.checkIn >= :startDate AND re.checkOut <= :endDate")
    List<Reservations> getAvailableRoomsForMonth(String startDate, String endDate);

    //핸드폰번호로 예약자 조회
    @Query("SELECT reservations FROM Reservations reservations Where reservations.phoneNumber = :phoneNumber")
    List<Reservations> phoneNumberSearch(String phoneNumber);

    //방 번호로 예약조회
    @Query("SELECT reservations FROM Reservations reservations Where reservations.roomNo = :roomNo")
    List<Reservations> roomNumberSearch(int roomNo);

    //특정날짜로 예약조회
    @Query("SELECT reservations FROM Reservations reservations WHERE reservations.checkIn = (SELECT r.checkIn FROM Reservations r WHERE :requestDate = date(r.checkIn))")
    List<Reservations> dateSearch(Date requestDate);


}
