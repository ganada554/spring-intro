package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
//test�� ���� �帧�� �����ϴ°� �߿�!
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }


    @Test //�׽�Ʈ �ڵ�� �ѱ۷� ��� ��� ����
    void ȸ������() {
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
    void �ߺ�_ȸ��_����() {
        //given
        Member member1 = new Member();
        member1.setName("hello");

        Member member2 = new Member();
        member2.setName("hello");

        //when
     /*   memberService.join(member1); //assertThrows : �߻��� ���ܰ� ù ��° ���ڿ� ���� ���ܿ� ���� Ŭ�������� Ȯ��
        assertThrows(IllegalStateException.class, ()->memberService.join(member2)); */

        //�޼��� ����
        memberService.join(member1); //assertThrows : �߻��� ���ܰ� ù ��° ���ڿ� ���� ���ܿ� ���� Ŭ�������� Ȯ��
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("�̹� �����ϴ� ȸ���Դϴ�");

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}