package net.javaguides.springboot.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserDetailsService interface
 * 
 * @author Ramesh Fadatare
 */
@Service
public interface UserDetailsService {

	/**
	 * Load user by username
	 * 
	 * @param email the username
	 * @return the user details
	 * @throws UsernameNotFoundException if the user with the given username was not found
	 */
	UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;

}
