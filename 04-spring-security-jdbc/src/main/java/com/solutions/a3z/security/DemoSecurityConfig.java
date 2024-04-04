package com.solutions.a3z.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
	
	@Bean
	public UserDetailsManager userDetailsManager (DataSource dataSource) {
		
		return new JdbcUserDetailsManager(dataSource);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
		
		httpSecurity.authorizeHttpRequests(configurer ->
			configurer
			.requestMatchers(HttpMethod.GET, "employees").hasAnyRole("EMPLOYEE","MANAGER","ADMIN")
			.requestMatchers(HttpMethod.GET, "employees/**").hasAnyRole("EMPLOYEE","MANAGER","ADMIN")
			.requestMatchers(HttpMethod.POST, "employees").hasAnyRole("MANAGER","ADMIN")
			.requestMatchers(HttpMethod.PUT, "employees/**").hasAnyRole("MANAGER","ADMIN")
			.requestMatchers(HttpMethod.DELETE, "employees/**").hasRole("ADMIN")
		
		);
		//use http basic authentication
		httpSecurity.httpBasic(Customizer.withDefaults());
		
		
		//disable Cross Site Request Forgery
		//in general not required for stateless REST APIs that use POST PUT DELETE PATCH
		httpSecurity.csrf(csrf -> csrf.disable());
		
		return httpSecurity.build();
	}
	
	/* In memory store user details
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		
		UserDetails roze = User.builder()
				.username("roze")
				.password("{noop}roze123")
				.roles("EMPLOYEE")
				.build();
		
		UserDetails mary = User.builder()
				.username("mary")
				.password("{noop}mary456")
				.roles("MANAGER")
				.build();
		
		UserDetails marlo = User.builder()
				.username("marlo")
				.password("{noop}marlo789")
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(roze,mary,marlo);
	}
	*/

}
