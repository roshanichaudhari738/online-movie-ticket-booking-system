package com.example.onlinemovieticketbookingsys.security;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtService jwt;
	
	@Autowired
	private CustomUserDetailsService servise;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authHeader =
	            request.getHeader("Authorization");
		
		if(authHeader == null ||
		           !authHeader.startsWith("Bearer "))
		        {
		            filterChain.doFilter(request,response);
		            return;
		        }
		
		String token =
	            authHeader.substring(7);
		
		if(token == null || token.isBlank()) {
		    filterChain.doFilter(request, response);
		    return;
		}

		String email =
	            jwt.extractUsername(token);
		
		String role = jwt.extractRole(token);
		List<GrantedAuthority> authorities =
		        List.of(new SimpleGrantedAuthority(role));
		System.out.println("Auth "+authorities); 
		
		System.out.println("Auth " + authorities);
		System.out.println("Email = " + email);
		System.out.println("Role = " + role);
		
		UserDetails userDetails =
	            servise.loadUserByUsername(email);
		
		if(jwt.validateToken(
                token,
                userDetails))
        {
            UsernamePasswordAuthenticationToken
            authToken =
            new UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                authorities
            );

            SecurityContextHolder
            .getContext()
            .setAuthentication(authToken);
        }
		
		filterChain.doFilter(request,response);
		
	}

}
