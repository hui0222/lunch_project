package com.example.jpa;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class GroupCalculatorTest {
    static int n;   // 인원

    @BeforeAll
    static void init() {
        n = 10;
    }

    @Test
    public void testMemberGroupInfoNotNull() {
        GroupCalculator groupCal = new GroupCalculator();
        String groupInfo = groupCal.memberGroupInfo();
        System.out.println(n);
        Assert.notNull(groupInfo,"");
    }

}
