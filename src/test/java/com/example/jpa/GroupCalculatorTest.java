package com.example.jpa;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Map;

public class GroupCalculatorTest {
    static int n;   // 인원
    static int n2;   // 인원
    static GroupCalculator groupCal;

    @BeforeAll
    static void init() {
        n = 7;
        n2 = 8;
        groupCal = new GroupCalculator();
    }

    @Test // groupInfo NotNull 체크
    public void testMemberGroupInfoNotNull() {
        Map<String, Integer> groupInfo = groupCal.memberGroupInfo(n);
        Assert.notNull(groupInfo,"");
        Assert.notNull(groupInfo.get("group3"),"");
        Assert.notNull(groupInfo.get("group4"),"");
    }

    @Test // groupInfo check
    public void testMemberGroupInfoCheck() {
        Map<String, Integer> groupInfo = groupCal.memberGroupInfo(n);
        Assert.isTrue(groupInfo.size() == 2,"");
        Assert.isTrue(groupInfo.get("group3") == 1,"");
        Assert.isTrue(groupInfo.get("group4") == 1,"");
    }

    @Test // groupInfo check
    public void testMemberGroupInfoCheck2() {
        Map<String, Integer> groupInfo = groupCal.memberGroupInfo(n2);
        Assert.isTrue(groupInfo.size() == 2,"");
        Assert.isTrue(groupInfo.get("group3") == 0,"");
        Assert.isTrue(groupInfo.get("group4") == 2,"");
    }

}
