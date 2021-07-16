package hello.hellospring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;

class MemoryMemberRepositoryTest {

	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	@AfterEach //메서드가 끝날 때 마다 실행된다 - 저장소 clear
	public void afterEach() {
		repository.clearStore();
	}
	
	
	@Test
	public void save() { //저장이 잘 되는지 테스트
		Member member = new Member();
		member.setName("spring");
		repository.save(member);
		Member result = repository.findById(member.getId()).get(); //잘 저장이 됐나 id로 확인 - optional은 get으로 꺼낼 수 있음
		System.out.println("repository.findById(member.getId()) : " + repository.findById(member.getId()));
		System.out.println("repository.findById(member.getId()).get() : " + repository.findById(member.getId()).get()); //get() : 옵셔널을 까서 꺼내기
		//System.out.println("result = "+(result==member));
		
		//Assertions.assertEquals(member, result); //기대값, 넣는 값
		Assertions.assertThat(member).isEqualTo(result); //member가 result랑 똑같은지?
	}
	
	
	@Test
	public void findByName() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		Member result = repository.findByName("spring1").get();
		assertThat(result).isEqualTo(member1);
		
	}
	
	@Test
	public void findAll() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		List<Member> result = repository.findAll();
		System.out.println(result.size());
		assertThat(result.size()).isEqualTo(2);
	}
}
