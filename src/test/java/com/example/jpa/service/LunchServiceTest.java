package com.example.jpa.service;

import com.example.jpa.GroupCalculator;
import com.example.jpa.domain.Member;
import com.example.jpa.repository.MemberRepository;
import com.example.jpa.util.TeamEnum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

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
    public void teamShuffle() {
        Map<String, List<Member>> teamInfo = new HashMap<>();
        Long[] members = {1L,2L,3L,4L,5L,6L,7L,8L,9L,10L,12L,13L,14L,15L,16L};

        // 팀별 리스트 Map 에 넣기
        Arrays.stream(TeamEnum.values()).forEach( x -> {
            List<Member> memberList = memberRepository.findAllByMemberIdInAndTeam(members, x.getTeamName());
            Collections.shuffle(memberList);
            teamInfo.put(x.getTeam(), memberList);
        });

        teamInfo.forEach((groupIndex,memberList)->{
            System.out.println(groupIndex);
            memberList.forEach(member->{
                System.out.println(member.getMemberName());
            });
        });

    }

    @Test
    public void randomLunchTeam() {
        // todo 1. 인원을 받음
        Map<String, List<Member>> teamInfo = new HashMap<>();
        Map<String, List<Member>> group = new HashMap<>();

        Long[] members = {1L,2L,3L,4L,5L,6L,7L,8L,9L,10L,12L,13L,14L,15L,16L};
        int n = members.length;

        // 팀별 리스트 Map 에 넣기
        Arrays.stream(TeamEnum.values()).forEach( x -> {
            // 팀별 리스트
            List<Member> memberList = memberRepository.findAllByMemberIdInAndTeam(members, x.getTeamName());
            // 팀별로 중복이 없도록 처리하는 로직 추가
            Collections.shuffle(memberList);
            teamInfo.put(x.getTeam(), memberList);
        });

        // todo 2. 인원 수로 그룹4, 그룹3 갯수를 가져옴 (O)
        Map<String, Integer> groupInfo = groupCal.memberGroupInfo(n);
        int group4 = groupInfo.get("group4");
        int group3 = groupInfo.get("group3");

        // n개의 그룹 생성
        for(int i=0; i<group3 + group4; i++) {
            List<Member> memberList = new ArrayList<>();

            // 팀 전체
            for(int j=0; j<teamInfo.size(); j++) {
                String team = TeamEnum.valueOf(j).getTeam();
                // member 카운트가 0이 아닌 경우만
                if(teamInfo.get(team).size() > 0){

                    // member 의 첫번 째 인원만 넣고 삭제해줌
                    memberList.add(teamInfo.get(team).get(0));
                    teamInfo.get(team).remove(0);

                    // 멤버를 담는 리스트가 4일경우 다음 그룹으로 이동
                    if (memberList.size() == 4) {
                        break;
                    }
                }
            }
            group.put("group_" + i, memberList);
        }

        // todo 4. 모든 그룹정보에 그룹4, 그룹3을 담아서 리턴
        group.forEach((groupIndex,memberList)->{
            System.out.println(groupIndex);
            memberList.forEach(member->{
                System.out.println(member.getMemberName());
            });
        });

    }


}