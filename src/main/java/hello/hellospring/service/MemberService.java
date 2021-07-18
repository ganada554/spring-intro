package hello.hellospring.service;

import java.util.List;
import java.util.Optional;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class MemberService {

	private final MemberRepository memberRepository;

	//memberRepository를 외부에서 넣어 준다 -> DI
	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	//회원 가입
	public Long join(Member member) {
		//같은 이름은 가입 안 된다
		validateDuplicateMember(member); //코드가 길어지는 경우 메소드로 빼기
		
		memberRepository.save(member);
		return member.getId();
	}
	
	public void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName()) //반환값을 또 넣지 말고 바로 ifPresent로 넘어감
			.ifPresent(m->{ //ifPresent : member에 값이 있다면
				throw new IllegalStateException("이미 존재하는 회원입니다"); //메소드를 호출하기 위한 상태가 아닐 때
			});	//Optional이 아니었다면 if(member!=null) 이런 조건문을 썼을 것
	}
	
	//전체회원 조회
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}
	
	//
	public Optional<Member> findOne(Long memberId){
		return memberRepository.findById(memberId);
	}
	
}
