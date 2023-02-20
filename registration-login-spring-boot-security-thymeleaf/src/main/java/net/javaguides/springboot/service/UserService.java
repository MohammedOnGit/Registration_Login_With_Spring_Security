package net.javaguides.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.web.dto.UserRegistrationDto;

/**
 * Interface for UserService Implements UserDetailsService to provide
 * authentication functionality
 *
 * @author Ramesh Fadatare
 */
public interface UserService extends UserDetailsService {

	/**
	 * Saves the user information
	 *
	 * @param registrationDto DTO object holding user registration information
	 * @return User object with information saved in database
	 */
	User save(UserRegistrationDto registrationDto);
}
