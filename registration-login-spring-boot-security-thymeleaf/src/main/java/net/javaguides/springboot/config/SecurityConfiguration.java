package net.javaguides.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import net.javaguides.springboot.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	private UserService userService;

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}

    @SuppressWarnings("deprecation")
	@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configuring the HttpSecurity object
        http.authorizeRequests()
                // Permit access to all requests matching "/registration**"
                .requestMatchers("/registration**").permitAll()
                // Permit access to all requests matching "/js/**"
                .requestMatchers("/js/**").permitAll()
                // Permit access to all requests matching "/css/**"
                .requestMatchers("/css/**").permitAll()
                // Permit access to all requests matching "/img/**"
                .requestMatchers("/img/**").permitAll()
                // Require authentication for all other requests
                .anyRequest().authenticated().and()
                // Configuring form login
                .formLogin()
                // Set the login page URL to "/login"
                .loginPage("/login")
                // Permit all users to access the login page
                .permitAll().and()
                // Configuring logout
                .logout()
                // Invalidate the session when logging out
                .invalidateHttpSession(true)
                // Clear the authentication information when logging out
                .clearAuthentication(true)
                // Set the logout request matcher to match "/logout"
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                // Set the logout success URL to "/login?logout"
                .logoutSuccessUrl("/login?logout");
        return http.build();
    }
}
