package com.example.springsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	    @GetMapping("/home")
	    public String home() {
	        return "home";
	    }

	    @GetMapping("/")
	    public String root() {
	        return "home";
	    }

	    @GetMapping("/hello")
	    public String hello() {
	        return "hello";
	    }

	    @GetMapping("/login")
	    public String login() {
	        return "login";
	    }
	

}
