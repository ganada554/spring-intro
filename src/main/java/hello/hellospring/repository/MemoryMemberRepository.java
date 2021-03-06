package hello.hellospring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sound.midi.Sequence;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

//@Repository
public class MemoryMemberRepository implements MemberRepository {

	private static Map<Long, Member> store = new HashMap<>(); //저장소
	private static long sequence = 0L;
	
	
	@Override
	public Member save(Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		return Optional.ofNullable(store.get(id));
	}

	@Override
	public Optional<Member> findByName(String name) {
		return store.values().stream()
				.filter(member->member.getName().equals(name))
				.findAny();
	}

	@Override
	public List<Member> findAll() {
		return new ArrayList<>(store.values()); //store의 key는 id, value는 이름
	}
	
	public void clearStore() {
		store.clear();  //store 비우기
	}
	
}
