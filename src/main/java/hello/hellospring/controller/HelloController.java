package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@GetMapping("hello")
	public String hello(Model model) { //스프링이 모델을 만들어서 넘겨줌
		model.addAttribute("data", "hello!");
		
		return "hello";
	}
	
	@GetMapping("hello-mvc")
	public String helloMVC(Model model,
			@RequestParam("name") String name) { //required = false로 하면 값을 넘기지 않아도 오류 발생하지 않음
		
		model.addAttribute("name", name);
		
		return "hello-template";
	}
	
	@GetMapping("hello-string")
	@ResponseBody
	public String helloString(Model model,
			@RequestParam("name") String name) { //required = false로 하면 값을 넘기지 않아도 오류 발생하지 않음
		
		model.addAttribute("name", name);
		
		return "hello"+name; //화면에 hello ${name} 이 출력된다
	}
	
	@GetMapping("hello-api")
	@ResponseBody //json으로 반환
	public Hello helloApi(Model model,
			@RequestParam("name") String name) { //required = false로 하면 값을 넘기지 않아도 오류 발생하지 않음
		
		Hello hello = new Hello();
		hello.setName(name);
		
		return hello; //화면에 hello ${name} 이 출력된다
	}
	
	static class Hello{
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}
	
	
}
