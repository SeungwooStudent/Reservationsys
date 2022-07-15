package com.mayo.reservationsys.service;

import com.mayo.reservationsys.dto.ReservationBookDto;
import com.mayo.reservationsys.entity.Reservations;
import com.mayo.reservationsys.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;

    //예약자 전부 출력
    public List<Reservations> getReservations() {
        return reservationRepository.findAll();
    }

    //예약등록
    public String reservation(ReservationBookDto reservationBookDto) {
        System.out.println("reservation service");
        reservationRepository.save(
                Reservations.builder()
                        .roomNo(reservationBookDto.getRoomNo())
                        .userName(reservationBookDto.getName())
                        .phoneNumber(reservationBookDto.getPhoneNumber())
                        .userCount(reservationBookDto.getCount())
                        .startDate(reservationBookDto.getStartDate())
                        .endDate(reservationBookDto.getEndDate())
                        .service(reservationBookDto.isService())
                        .build());
        return "예약이 완료되었습니다.";
    }

//    //예약취소
//    @Transactional
//    public String reservationCancel(ReservationCancelDto reservationCancelDto) {
//        reservationRepository.reservationCancel(reservationCancelDto);
//        return "예약이 취소되었습니다";
//    }
//
//    //예약확인,검색
//    @Transactional
//    public List<Reservation> reservationSearch(ReservationSearchDto reservationSearchDto) {
//        return reservationRepository.searchUser(reservationSearchDto);
//    }

    //예약수정,
    @Transactional
    public String updateUser(int id, String name, String phoneNumber, int count, boolean service) {
        if (!reservationRepository.findById(id).isPresent()) {
            return "회원님의 ID를 다시한번 확인해주세요";
        }
        int result = reservationRepository.updateUser(id, name, phoneNumber, count, service);
        if (result == 1) {
            return "변경사항이 수정되었습니다.";
        }
        return "변경사항에 에러가 발생하였습니다";
    }
}
