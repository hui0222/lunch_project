package com.example.jpa;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Map;

public class GroupCalculatorTest {
    static int n;   // 인원
    static GroupCalculator groupCal;

    @BeforeAll
    static void init() {
        n = 7;
        groupCal = new GroupCalculator();
    }

    @Test // groupInfo NotNull 체크
    public void testMemberGroupInfoNotNull() {
        Map<String, Integer> groupInfo = groupCal.memberGroupInfo(n);
        Assert.notNull(groupInfo,"");
        Assert.notNull(groupInfo.get("group_3"),"");
        Assert.notNull(groupInfo.get("group_4"),"");
    }

    @Test // groupInfo check
    public void testMemberGroupInfoCheck() {
        Map<String, Integer> groupInfo = groupCal.memberGroupInfo(n);
        Assert.isTrue(groupInfo.size() == 2,"");
        Assert.isTrue(groupInfo.get("group_3") == 1,"");
        Assert.isTrue(groupInfo.get("group_4") == 1,"");
    }

}
