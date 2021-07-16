package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloApplication { //스프링 실행시킴

	public static void main(String[] args) { 
		SpringApplication.run(HelloApplication.class, args);
	}

}
