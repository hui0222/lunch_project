package com.example.jpa.controller;

import com.example.jpa.domain.Member;
import com.example.jpa.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService = new MemberService();

    @PostMapping("/member")
    public Member insertMember(Member member) {
        return memberService.memberSave(member);
    }

    @DeleteMapping("/member/{memberId}")
    public String DeleteMember(@PathParam("memberId") Long memberId) {
        String result="delete";
        memberService.memberDelete(memberId);
        return result;
    }

    @GetMapping("/member")
    public List<Member> getMemberList() {
        return memberService.findAll();
    }
}
