create table rooms (
    room_no varchar(10) primary key,
    room_description varchar(1000) not null,
    room_count int not null,
    room_name varchar(20) not null
);

create table reservations (
    reservation_seq bigint auto_increment primary key,
    user_count int not null,
    user_name varchar(20) not null,
    phone_number varchar(20) not null,
    room_no varchar(10) not null,
    service boolean not null,
    start_date datetime not null,
    end_date datetime not null,
    ins_dtm datetime not null,
    upd_dtm datetime not null
);

insert into rooms values("1001", "객실설명 : - 모던한 실내 2층 인테리어의 신축펜션 - 시원한 야외 수영장 완비 - 계곡 근처 위치 - 애견공원 및 운동장 4천평 규모, 애견동반 수영장 2개", 4, "Blue");
insert into rooms values("1002", "55인치 스마트 TV(위성 TV 48개 채널)\n50~100Mbps 초고속 유·무선(wifi) 인터넷 무료\n220V, 110V 전압 사용 가능\n커피·차 티백 무료 제공\n엑스트라 베드 1개 추가 36,300원/1박\n베이비 크립(무료)", 6, "RED");
insert into rooms values("1003", "침대방1개/온돌방1개/욕실2개/대형정글짐놀이터/개별수영장/개별바베큐/주방 (수영장 사용시 미온수 신청 필, 이용시간 오후 15:00~22:00)", 2, "GREEN");
insert into rooms values("1004", "피트니스 클럽 이용 안내\n- 체육관(Gym) 무료 이용(만 16세 이상 입장 가능)\n- 실내 수영장 무료 이용(만 13세 이상 입장 가능)", 2, "WHITE");
