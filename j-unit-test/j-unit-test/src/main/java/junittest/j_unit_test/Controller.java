package junittest.j_unit_test;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller {
	
	@RequestMapping("/hello")
	public @ResponseBody String greetings() {
		return "Hello, world";
	}

}
