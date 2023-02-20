package net.javaguides.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Specifying that this class is a controller in the spring application
@Controller
public class MainController {

	// Mapping the "/login" URL to the login() method
	@GetMapping("/login")
	public String login() {
		// Returning the string "login" which is the name of the view
		return "login";
	}

	// Mapping the "/" URL to the home() method
	@GetMapping("/")
	public String home() {
		// Returning the string "index" which is the name of the view
		return "index";
	}
}
