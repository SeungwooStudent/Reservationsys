package com.mayo.reservationsys.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor //모든 필드값을 파라미터로 받는 생성자
@NoArgsConstructor //파라미터가 없는 기본 생성자
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Rooms {
    @Id
    @Column(name = "room_no")
    private String roomNo;

    @Column(name = "room_name")
    private String roomName;

    @Column(name = "room_count")
    private int roomCount;

    @Column(name = "room_description")
    private String roomDescription;

}
