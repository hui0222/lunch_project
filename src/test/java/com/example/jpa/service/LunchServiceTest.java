package com.example.jpa.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LunchServiceTest {

    /*
     Q. 인원 수 및 참여인원 정보를 받아서 인원수에 맞는 팀을 구성
     -> 최소인원은 6인이상
     -> 4명, 3명 그룹으로 만들어줌 (코로나 영향)
     -> 같은팀은 최소한으로 겹치게

     n : 총 인원 수
     group_4 : 4명인 그룹의 개수
     group_3 : 3명인 그룹의 개수
     quotient_4 : n을 4로 나눈 몫
     remainder_4 : n을 4로 나눈 나머지
    */
    @Test
    public void test() {
        // todo 1. 인원을 받음
        // todo 2. 인원 수로 그룹4, 그룹3 갯수를 가져옴 (O)
        // todo 3. 인원을 그룹4, 그룹3에 차례대로 분배해줌
        // todo 4. 모든 그룹정보에 그룹4, 그룹3을 담아서 리턴

        // todo 5. 팀별로 중복이 없도록 처리하는 로직 추가

    }

}