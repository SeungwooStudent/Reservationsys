package com.mayo.reservationsys.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor //모든 필드값을 파라미터로 받는 생성자
@NoArgsConstructor //파라미터가 없는 기본 생성자
public class User {
    @Id
    private String id;
    private String password;

}
