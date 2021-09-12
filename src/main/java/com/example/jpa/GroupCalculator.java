package com.example.jpa;

import java.util.HashMap;
import java.util.Map;

public class GroupCalculator {
    public Map<String, Integer> memberGroupInfo(int n) {
        Map<String, Integer> memberGroupInfo = new HashMap<>();
        memberGroupInfo.put("group_3", 1);
        memberGroupInfo.put("group_4", 1);
        return memberGroupInfo;
    }
}
