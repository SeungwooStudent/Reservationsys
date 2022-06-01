package com.mayo.reservationsys.service;

import com.mayo.reservationsys.entity.Reservation;
import com.mayo.reservationsys.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;

    //예약자 전부 출력
    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    //예약등록
    public String reservation(int roomNo, String name, String phoneNumber, int count, Date startDate, Date endDate, boolean service) {
        reservationRepository.save(Reservation.builder().roomNo(roomNo).name(name).phoneNumber(phoneNumber).count(count).startDate(startDate).endDate(endDate).service(service).build());
        return "예약이 완료되었습니다.";
    }

    //예약취소
    @Transactional
    public String reservationCancel(int id) {
        reservationRepository.reservationCancel(id);
        return "예약이 취소되었습니다";
    }

    //예약확인,검색
    @Transactional
    public List<Reservation> reservationSearch(String name, String phoneNumber) {
        return reservationRepository.searchUser(name, phoneNumber);
    }

    //예약수정,
//    @Transactional
//    public String updateUser(String name, String phoneNumber, int count, boolean service) {
//        int result = reservationRepository.updateUser(name, phoneNumber, count, service);
//        if(result == 1) {
//            return "변경사항이 수정되었습니다.";
//        } return "다시한번 확인!";
//    }
}
