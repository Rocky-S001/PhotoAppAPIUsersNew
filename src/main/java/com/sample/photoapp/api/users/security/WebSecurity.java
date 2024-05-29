package com.sample.photoapp.api.users.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurity {

	protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable());

		http.authorizeHttpRequests(auth -> {
			try {
				auth.requestMatchers(HttpMethod.POST, "/users").permitAll()
						.requestMatchers(new AntPathRequestMatcher("/h2-console/**"))
						.permitAll().and()
						.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		http.headers(headers -> headers.frameOptions(frames -> frames.disable()));

		return http.build();
	}

}
