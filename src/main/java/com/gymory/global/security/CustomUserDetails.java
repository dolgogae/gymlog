package com.gymory.global.security;

import com.gymory.domain.user.userbase.data.UserBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Getter
@NoArgsConstructor
@ToString
public class CustomUserDetails extends UserBase implements UserDetails {
    private Long id;
    private String email;
    private String userRole;
    private String password;

    private CustomUserDetails(UserBase user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.userRole = user.getRole().getKey();
    }

    private CustomUserDetails(String email, String userRole) {
        this.email = email;
        this.userRole = userRole;
    }

    private CustomUserDetails(String email, String password, String userRole) {
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    public static CustomUserDetails of(UserBase user) {
        return new CustomUserDetails(user);
    }

    public static CustomUserDetails of(String email, String role) {
        return new CustomUserDetails(email, role);
    }

    public static CustomUserDetails of(String email, String password, String role) {
        return new CustomUserDetails(email, password, role);
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        return CustomAuthorityUtils.createAuthorities(userRole);
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}