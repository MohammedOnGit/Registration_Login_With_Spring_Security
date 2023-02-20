package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.User;

/**
 * UserRepository interface
 *
 * @author Ramesh Fadatare
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Find user by email
	 *
	 * @param email the email
	 * @return the user
	 */
	User findByEmail(String email);

	/**
	 * Find user by username
	 *
	 * @param username the username
	 * @return the user
	 */
	
	
	/* User findByUsername(String username); */
}
