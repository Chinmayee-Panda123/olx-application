package com.olx.user.security;

//import io.jsonwebtoken.Claims;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

    // Inject the secret key from application properties
    @Value("${jwt.secret}")
    private String jwtSecret;

    // JWT expiration time (e.g., 1 hour)
    @Value("${jwt.expiration}")
    private long jwtExpiration;

    // Generate a JWT token
    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpiration);

        return Jwts.builder()
                .setSubject(username)  // Set the username as the subject
                .setIssuedAt(now)      // Set the issued date
                .setExpiration(expiryDate)  // Set the expiration date
                .signWith(SignatureAlgorithm.HS512, jwtSecret)  // Sign the token with the secret
                .compact();
    }

    // Validate the JWT token and check if it's expired
    public boolean validateToken(String token) {
        try {
            Claims claims = extractCl+aims(token);  // Extract claims (payload)
            return !claims.getExpiration().before(new Date());  // Check expiration
        } catch (Exception e) {
            return false;
        }
    }

    // Extract username (subject) from the JWT token
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // Extract all claims from the JWT token
    private Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
    }
}
