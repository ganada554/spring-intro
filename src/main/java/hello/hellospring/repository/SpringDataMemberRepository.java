package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//�������̽��� ���߻�� ����
//JpaRepository�� ��ӹ޾ƾ� ��                                            �ĺ���(id) Ÿ��
public interface SpringDataMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //��Ģ�� ����. JPQL : select m from Member where m.name = ?
    //�ܼ��� sql���� �������̽� �̸������� ������ ���� -> findByNameAndId...
    @Override
    Optional<Member> findByName(String name);
}
