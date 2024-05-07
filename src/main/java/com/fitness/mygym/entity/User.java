package com.fitness.mygym.entity;

import com.fitness.mygym.constans.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User implements UserDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String username;
    private String password;
    @Column(name = "role_id")
    private int roleId;
    private String name;
    private String phone;
    private String email;
    private Status status;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return a collection of user authorities (roles)
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER")); // Example role
        // Replace with your logic to retrieve user roles from database or other source
        return authorities;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Replace with logic to check account expiration if needed
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Replace with logic to check account lock status if needed
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Replace with logic to check credential expiration if needed
    }

    @Override
    public boolean isEnabled() {
        return true; // Replace with logic to check account enabled status if needed
    }
}

