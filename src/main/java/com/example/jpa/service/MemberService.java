package com.example.jpa.service;

import com.example.jpa.domain.Member;
import com.example.jpa.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public Member memberSave(Member member){
        return memberRepository.save(member);
    }

    public void memberDelete(Long memberId){
        Member member = new Member();
        member.setMemberId(memberId);
        memberRepository.delete(member);
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }
}
