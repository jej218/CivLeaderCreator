package com.civleadercreator.security;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers(
					"/", 
					"/register",
					"/materialize/css/**", 
					"/materialize/js/**",
					"/iconpacks/religion/**",
					"/images/**",
					"/js/**", 
					"/css/**")
			.permitAll()
			.anyRequest().authenticated();
		// point login view towards @GetMapping("/login") and set the custom username parameter to "email"
		// This lets us use the User username column as the email, as it is required to be a unique identifier;
		// Also always send the user back to the welcome page after successfully signing in.
		http.formLogin(form -> form
				.loginPage("/login")
				.usernameParameter("email")
				.permitAll()
				.defaultSuccessUrl("/home", true)
				.failureUrl("/login?error=true"));
		
		http.logout(logout -> logout
				.logoutSuccessUrl("/")
				);
		
		return http.build();
	}
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Resource(name="UserServiceImpl")
	private UserDetailsService userDetailsService;
	
	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder);
		return authProvider;
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider());
	}
	
}
