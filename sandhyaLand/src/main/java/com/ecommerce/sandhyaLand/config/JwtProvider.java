package com.ecommerce.sandhyaLand.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtProvider {

    SecretKey secretKey= Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());
    public String generateToken(Authentication auth) {
        String jwt = Jwts.builder()
                .setIssuedAt(new Date()) // Set the issued date to the current time
                .setExpiration(new Date(new Date().getTime() + 846000000 )) // Set the expiration time
                .claim("email", auth.getName()) // Add custom claim "email" with the user's name
                .signWith(secretKey) // Sign the token using the provided key
                .compact(); // Build and serialize the JWT to a compact string

        return jwt; // Return the generated token
    }

    public String getEmailFromToken(String jwt) {
        // Remove the "Bearer " prefix if it exists
        jwt = jwt.substring(7);

        // Parse the JWT using the signing key, and extract the claims
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(jwt)
                .getBody();

        // Get the "email" claim from the token's payload
        String email = String.valueOf(claims.get("email"));

        // Return the extracted email
        return email;
    }


}
