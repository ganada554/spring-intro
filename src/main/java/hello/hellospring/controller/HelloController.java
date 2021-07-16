package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@GetMapping("hello")
	public String hello(Model model) { //�������� ���� ���� �Ѱ���
		model.addAttribute("data", "hello!");
		
		return "hello";
	}
	
	@GetMapping("hello-mvc")
	public String helloMVC(Model model,
			@RequestParam("name") String name) { //required = false�� �ϸ� ���� �ѱ��� �ʾƵ� ���� �߻����� ����
		
		model.addAttribute("name", name);
		
		return "hello-template";
	}
	
	@GetMapping("hello-string")
	@ResponseBody
	public String helloString(Model model,
			@RequestParam("name") String name) { //required = false�� �ϸ� ���� �ѱ��� �ʾƵ� ���� �߻����� ����
		
		model.addAttribute("name", name);
		
		return "hello"+name; //ȭ�鿡 hello ${name} �� ��µȴ�
	}
	
	@GetMapping("hello-api")
	@ResponseBody //json���� ��ȯ
	public Hello helloApi(Model model,
			@RequestParam("name") String name) { //required = false�� �ϸ� ���� �ѱ��� �ʾƵ� ���� �߻����� ����
		
		Hello hello = new Hello();
		hello.setName(name);
		
		return hello; //ȭ�鿡 hello ${name} �� ��µȴ�
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
