package net.javaguides.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	// UserService instance
	private UserService userService;

	// Constructor to initialize UserService instance
	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}

	// Create a ModelAttribute for the registration form
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}

	// Get method to return the registration form
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}

	// Post method to handle the form submission
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		// Save the user's information to the database
		userService.save(registrationDto);
		// Redirect to the registration page with a success message
		return "redirect:/registration?success";
	}
}
