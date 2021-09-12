package com.example.jpa;

import java.util.HashMap;
import java.util.Map;

public class GroupCalculator {

    // 총 멤머를 넣으면 그룹3명, 그룹4명의 갯수 리턴
    public Map<String, Integer> memberGroupInfo(int n) {
        return memberGroupCalculator(totalMemberQuotient4(n), totalMemberRemainder4(n));
    }

    // 총 멤머 4로 나눈 몫
    public int totalMemberQuotient4 (int n) {
        return n/4;
    }

    // 총 멤머 4로 나눈 나머지
    public int totalMemberRemainder4 (int n) {
        return n%4;
    }

    // 총 멤버의 4로 나눈 값들로  그룹3명, 그룹4명의 갯수 가져오기
    public  Map<String, Integer> memberGroupCalculator (int quotient4, int remainder4) {
        Map<String, Integer> memberGroupInfo = new HashMap<>();

        if(remainder4 == 0){
            memberGroupInfo.put("group3", 0);
            memberGroupInfo.put("group4", quotient4);
        }

        // 2. 4로 나눴을 때 나머지 3
        if(remainder4 == 3){
            memberGroupInfo.put("group3", 1);
            memberGroupInfo.put("group4", quotient4);
        }

        // 3. 4로 나눴을 때 나머지 2
        if(remainder4 == 2){
            memberGroupInfo.put("group3", 2);
            memberGroupInfo.put("group4", quotient4-1);
        }

        // 4. 4로 나눴을 때 나머지 1
        if(remainder4 == 1){
            memberGroupInfo.put("group3", 3);
            memberGroupInfo.put("group4", quotient4-2);
        }

        return memberGroupInfo;
    }
}
