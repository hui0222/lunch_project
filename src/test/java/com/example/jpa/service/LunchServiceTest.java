package com.example.jpa.service;

import com.example.jpa.GroupCalculator;
import com.example.jpa.domain.Member;
import com.example.jpa.repository.MemberRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
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
    static GroupCalculator groupCal;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeAll
    static void init() {
        groupCal = new GroupCalculator();
    }

    @Test
    public void test() {
        // todo 1. 인원을 받음
        Map<String, List<Member>> group = new HashMap<>();

        List<Member> memberList = memberRepository.findAll(); // todo 정렬필요
        int n = memberList.size();


        // todo 2. 인원 수로 그룹4, 그룹3 갯수를 가져옴 (O)
        Map<String, Integer> groupInfo = groupCal.memberGroupInfo(n);
        int group4 = groupInfo.get("group4");
        int group3 = groupInfo.get("group3");

        // 1차 차감
        // todo 3. 인원을 그룹4, 그룹3에 차례대로 분배해줌
        for(int i=0; i<group4; i++) {
            List<Member> memberSet = new ArrayList<>();
            memberSet.add(memberList.get(0));
            memberSet.add(memberList.get(1));
            memberSet.add(memberList.get(2));
            memberSet.add(memberList.get(3));
            memberList.remove(0);
            memberList.remove(0);
            memberList.remove(0);
            memberList.remove(0);
            group.put("group4_"+i, memberSet);
        }

        // 2차 차감
        for(int i=0; i<group3; i++) {
            List<Member> memberSet = new ArrayList<>();
            memberSet.add(memberList.get(0));
            memberSet.add(memberList.get(1));
            memberSet.add(memberList.get(2));
            memberList.remove(0);
            memberList.remove(0);
            memberList.remove(0);
            group.put("group3_"+i, memberSet);

        }

        // todo 4. 모든 그룹정보에 그룹4, 그룹3을 담아서 리턴
        System.out.println(group);

        // todo 5. 팀별로 중복이 없도록 처리하는 로직 추가
    }


}