package com.mayo.reservationsys.service;

import com.mayo.reservationsys.dto.reservations.*;
import com.mayo.reservationsys.entity.Reservations;
import com.mayo.reservationsys.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;

    //예약자 전부 출력
    public List<ReservationInfoDto> getReservations() {
        return reservationRepository.findReservations();
    }

    //예약등록
    public String book(ReservationBookDto reservationBookDto) {
        System.out.println("reservation service");
        reservationRepository.save(
                Reservations.builder()
                        .roomNo(reservationBookDto.getRoomNo())
                        .userName(reservationBookDto.getUserName())
                        .phoneNumber(reservationBookDto.getPhoneNumber())
                        .userCount(reservationBookDto.getUserCount())
                        .checkIn(reservationBookDto.getCheckIn())
                        .checkOut(reservationBookDto.getCheckOut())
                        .service(reservationBookDto.isService())
                        .build());
        return "예약이 완료되었습니다.";
    }

    //예약취소
    @Transactional
    public String reservationCancel(@PathVariable Long seq) {
        reservationRepository.reservationCancel(seq);
        return "예약이 취소되었습니다";
    }

    //예약확인,검색
    @Transactional
    public List<Reservations> reservationSearch(ReservationSearchDto reservationSearchDto) {
        return reservationRepository.searchUser(reservationSearchDto.getUserName(),reservationSearchDto.getPhoneNumber());
    }

    //예약수정,
    @Transactional
    public String updateUser(long id, ReservationUpdateDto reservationUpdateDto) {
        if (!reservationRepository.findById(id).isPresent()) {
            return "회원님의 ID를 다시한번 확인해주세요";
        }
        int result = reservationRepository.updateUser(id,reservationUpdateDto.getUserName(),reservationUpdateDto.getPhoneNumber(),reservationUpdateDto.getUserCount(),reservationUpdateDto.isService());
        if (result == 1) {
            return "변경사항이 수정되었습니다.";
        }
        return "변경사항에 에러가 발생하였습니다";
    }

    //특정날짜로 예약가능한 방 조회
    @Transactional
    public List<ReservationCheckDto> availableRooms(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date requestDate = simpleDateFormat.parse(date);
        return reservationRepository.getAvailableRooms(requestDate);
    }

    //핸드폰번호로 예약자 조회
    @Transactional
    public List<Reservations> phoneNumberSearch(String phoneNumber) {
        return reservationRepository.phoneNumberSearch(phoneNumber);
    }

    //방 번호로 예약자 조회
    @Transactional
    public List<Reservations> roomNumberSearch(int roomNo) {
       return reservationRepository.roomNumberSearch(roomNo);
    }

    //특정날짜로 에약자조회
    @Transactional
    public List<Reservations> dateSearch(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date requestDate = simpleDateFormat.parse(date);
        return reservationRepository.dateSearch(requestDate);
    }
}
