package hello.hellospring.repository;

import java.util.List;
import java.util.Optional;

import hello.hellospring.domain.Member;

public interface MemberRepository {
	Member save(Member member); //회원 저장소에 저장
	Optional<Member> findById(Long id); 
	Optional<Member> findByName(String name);
	List<Member> findAll(); //모든 회원 목록
}
