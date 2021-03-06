package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest { //스프링 통합테스트
//test는 예외 흐름을 검증하는게 중요!

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;




    @Test //테스트 코드는 한글로 적어도 상관 없다
    //@Commit //롤백되지 않고 DB에 커밋함
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("hello");

        Member member2 = new Member();
        member2.setName("hello");

        //when
     /*   memberService.join(member1); //assertThrows : 발생한 예외가 첫 번째 인자에 넣은 예외와 같은 클래스인지 확인
        assertThrows(IllegalStateException.class, ()->memberService.join(member2)); */

        //메세지 검증
        memberService.join(member1); //assertThrows : 발생한 예외가 첫 번째 인자에 넣은 예외와 같은 클래스인지 확인
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");

        //then
    }


}