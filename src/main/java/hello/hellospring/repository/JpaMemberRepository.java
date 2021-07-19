package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Transactional
public class JpaMemberRepository implements MemberRepository {

    //jpa�� ��ƼƼ �Ŵ����� ����
    private final EntityManager em;

    //�����ڰ� �� ���� ������ @Autowired ���� ����
    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member); //�� �˾Ƽ� �� ����
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);//��ȸ�� ����� Ŭ���� Ÿ��, �ĺ���
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() { //m : ��ü(��ƼƼ)�� ����
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}

