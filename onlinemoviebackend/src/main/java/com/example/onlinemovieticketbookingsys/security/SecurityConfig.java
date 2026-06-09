package com.example.onlinemovieticketbookingsys.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
	@Autowired
	private JwtFilter jwt;
	
	@Bean
    public SecurityFilterChain securityFilterChain(
        HttpSecurity http) throws Exception {

        http
        	.cors(cors -> {})
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
            		.requestMatchers(
                            "/user/add" ,
                            "/user/login",
                            "/images/**"
            				).permitAll()  //allowed all request means the public all request kisi request ko authenticate nahi karenge
            		.requestMatchers("/admin/**")
            	    .hasAuthority("ADMIN")
            	    
            	    .requestMatchers("/user/**")
            	    .hasAnyAuthority(
            	            "USER",
            	            "ADMIN"
            	    )
            	    
            		.anyRequest().authenticated()
                  
            );
        http.sessionManagement(session ->
        session.sessionCreationPolicy(
                SessionCreationPolicy.STATELESS
        )
        );
        http.addFilterBefore(jwt, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
