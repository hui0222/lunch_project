package com.example.jpa.repository;

import com.example.jpa.JpaApplication;
import com.example.jpa.domain.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

// junit5에서는 @RunWith 대신에 @ExtendWith(SpringExtend.class)을 사용한다.
@ExtendWith(SpringExtension.class)
// JPA 관련된 Component만 로드 된다.
// @DataJpaTest는 기본적으로 @Transactional 어노테이션을 포함하고 있습니다.
// 그래서 테스트가 완료되면 자동으로 롤백하기 때문에 직접 선언적 트렌젝션 어노테이션을 달아줄 필요가 없습니다.
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@AutoConfigureTestDatabase 어노테이션의 기본 설정값인 Replace.Any를 사용하면 기본적으로 내장된 임베디드 데이터베이스를 사용합니다.
// 위의 코드에서 Replace.NONE로 설정하면 @ActiveProfiles에 설정한 프로파일 환경값에 따라 데이터 소스가 적용됩니다
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void insert(){
        Member member = new Member();
        member.setMemberName("Hwi");
        member.setTeam("DEV");
        memberRepository.save(member);
    }

    @Test
    void delete(){
        Member member = new Member();
        member.setMemberId(1L);
        memberRepository.delete(member);
    }

    @Test
    void list(){

        List<Member> memberList = memberRepository.findAll();
        System.out.println(memberList);
    }
}