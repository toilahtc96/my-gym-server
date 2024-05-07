package com.fitness.mygym.security;

import com.fitness.mygym.entity.User;
import com.fitness.mygym.repository.UserRepository;
import io.jsonwebtoken.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
//import org.springframework.vault.annotation.VaultPropertySource;

import java.util.Date;

@Slf4j
@Service
@AllArgsConstructor
//@VaultPropertySource("secret/gogo")
public class JwtTokenProvider {

    @Autowired
    Environment env;
    private final UserRepository userRepository;


    public String generateToken(User user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 1000 * 60 * 60 * 10); // 10 hours

        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, "jwt_secret") //env.getProperty("jwt_secret")
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey("jwt_secret") // //env.getProperty("jwt_secret")
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey("jwt_secret").parseClaimsJws(token); //env.getProperty("jwt_secret")
            return true;
        } catch (SignatureException ex) {
            log.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty");
        }
        return false;
    }

    public Authentication getAuthentication(String token) {
        // Decode the token and get username
        String username = getUsernameFromToken(token);

        // Fetch user details from database (replace with your logic)
        User users = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // Create an Authentication object with the user details
        return new UsernamePasswordAuthenticationToken(users, null, users.getAuthorities());
    }

}