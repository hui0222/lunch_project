package com.example.jpa.controller;

import com.example.jpa.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MemberController {


    @PutMapping("/member")
    public String putMember() {
        String result="";

        return result;
    }

    @GetMapping("/member")
    public List<Member> getMemberList() {
        List<Member> members = new ArrayList<>();
        return members;
    }
}
