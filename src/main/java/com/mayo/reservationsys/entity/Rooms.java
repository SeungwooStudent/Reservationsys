package com.mayo.reservationsys.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value="방번호", dataType = "String", required = true, example = "1001")
    private String roomNo;

    @Column(name = "room_name")
    @ApiModelProperty(value="방이름", dataType = "String", required = true, example = "RED")
    private String roomName;

    @Column(name = "room_count")
    @ApiModelProperty(value="입실가능한 인원수", dataType = "Integer", required = true, example = "10")
    private int roomCount;

    @Column(name = "room_description")
    @ApiModelProperty(value="방설명", dataType = "String", required = true, example = " 모던한 실내 2층 인테리어의 신축펜션")
    private String roomDescription;

}
