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

	//memberRepository�� �ܺο��� �־� �ش� -> DI
	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	//ȸ�� ����
	public Long join(Member member) {
		//���� �̸��� ���� �� �ȴ�
		validateDuplicateMember(member); //�ڵ尡 ������� ��� �޼ҵ�� ����
		
		memberRepository.save(member);
		return member.getId();
	}
	
	public void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName()) //��ȯ���� �� ���� ���� �ٷ� ifPresent�� �Ѿ
			.ifPresent(m->{ //ifPresent : member�� ���� �ִٸ�
				throw new IllegalStateException("�̹� �����ϴ� ȸ���Դϴ�"); //�޼ҵ带 ȣ���ϱ� ���� ���°� �ƴ� ��
			});	//Optional�� �ƴϾ��ٸ� if(member!=null) �̷� ���ǹ��� ���� ��
	}
	
	//��üȸ�� ��ȸ
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}
	
	//
	public Optional<Member> findOne(Long memberId){
		return memberRepository.findById(memberId);
	}
	
}
