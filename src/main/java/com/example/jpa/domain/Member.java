package com.example.jpa.domain;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // primary key에 대한 생성 전략을 지정하는 annotation, Id annotation과 함께 entity의 primary key에 적용될 수 있다.
    @Column(name = "member_id")
    private Long memberId;

    @NotNull
    @Column(name = "member_name")
    private String memberName;

    @NotNull
    @Column(name = "team")
    private String team;

}
