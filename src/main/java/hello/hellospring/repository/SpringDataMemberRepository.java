package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//인터페이스는 다중상속 가능
//JpaRepository를 상속받아야 함                                            식별자(id) 타입
public interface SpringDataMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //규칙이 있음. JPQL : select m from Member where m.name = ?
    //단순한 sql문은 인터페이스 이름만으로 개발이 끝남 -> findByNameAndId...
    @Override
    Optional<Member> findByName(String name);
}
