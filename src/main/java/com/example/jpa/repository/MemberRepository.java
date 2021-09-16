package com.example.jpa.repository;

import com.example.jpa.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

    List<Member> findAllByMemberIdInAndTeam(Long[] longs, String team);
}
