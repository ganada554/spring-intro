package hello.hellospring.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //jpa�� �����ϴ� ��ƼƼ
public class Member {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) //id���� DB�� ����
	private Long id;
	private String name;
	
	
	public Member() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + "]";
	}
	
}
