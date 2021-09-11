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
        int n = 6;

        for (int i=n; i<20; i++) {
            System.out.println("[start] n:"+i);
            getGroupInfo(i);
        }
    }

    public void getGroupInfo(int n) {
        int quotient_4 = n/4;
        int remainder_4 = n%4;

        int group_4 = 0;
        int group_3 = 0;

        // 1. 4로 나눴을 때 나머지 0
        if(remainder_4 == 0){
            group_4 = quotient_4;  // 몫이 총 그룹수
            group_3 = 0;
        }

        // 2. 4로 나눴을 때 나머지 3
        if(remainder_4 == 3){
            group_4 = quotient_4;
            group_3 = 1;
        }

        // 3. 4로 나눴을 때 나머지 2
        if(remainder_4 == 2){
            group_4 = quotient_4-1;
            group_3 = 2;
        }

        // 4. 4로 나눴을 때 나머지 1
        if(remainder_4 == 1){
            group_4 = quotient_4-2;
            group_3 = 3;
        }

        System.out.println("group_3 : " + group_3);
        System.out.println("group_4 : " + group_4);
    }

}