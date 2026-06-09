package com.example.onlinemovieticketbookingsys.security;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.onlinemovieticketbookingsys.beans.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	@Value("${jwt.secret}")
	private String secret;
	
	//secret key generate
	public Key generateKey()
	{
		return Keys.hmacShaKeyFor(secret.getBytes());
	}
	
	
	
	public String generateToken(String email,User u)
	{
		return Jwts.builder().
				setSubject(email).
				claim("role",u.getRole()).
				
				setIssuedAt(new Date()).
				setExpiration(new Date(
						System.currentTimeMillis()+
						1000 * 60 * 60
						)
						)
				.signWith(generateKey())
                .compact();
	}
	
	public String extractUsername(String token) {

	    return Jwts.parserBuilder()
	            .setSigningKey(generateKey())
	            .build()
	            .parseClaimsJws(token) //check the validation of token like token valid hai kya , token signature correct hai kya 
                .getBody()
                .getSubject()
                ;
	}
	
	public String extractRole(String token) {

	    return Jwts.parserBuilder()
	            .setSigningKey(generateKey())
	            .build()
	            .parseClaimsJws(token) //check the validation of token like token valid hai kya , token signature correct hai kya 
                .getBody()
                .get("role", String.class);
	}
	
	public boolean validateToken(
    	    String token,
    	    UserDetails userDetails)
    	{
    	    String username =
    	        extractUsername(token);

    	    return username.equals(
    	           userDetails.getUsername());
    	}
}
