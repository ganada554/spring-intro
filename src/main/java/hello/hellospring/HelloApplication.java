package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //여기서부터 하위 패키지만 컴포넌트 스캔
public class HelloApplication { //스프링 실행시킴

	public static void main(String[] args) { 
		SpringApplication.run(HelloApplication.class, args);
	}

}
