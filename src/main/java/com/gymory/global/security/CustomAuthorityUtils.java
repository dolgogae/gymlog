package com.gymory.global.security;

import com.gymory.domain.user.UserRole;
import com.gymory.global.code.error.ErrorCode;
import com.gymory.global.code.error.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

@Slf4j
public class CustomAuthorityUtils {
    public static List<GrantedAuthority> createAuthorities(String role) {
        return List.of(new SimpleGrantedAuthority(role));
    }

    public static void verifiedRole(String role) {
        if (role == null) {
            throw new BusinessException(ErrorCode.USER_ROLE_DOES_NOT_EXISTS);
        } else if (!role.equals(UserRole.USER.toString())
                && !role.equals(UserRole.ADMIN.toString())
                && !role.equals(UserRole.ANONYMOUS.toString())) {
            throw new BusinessException(ErrorCode.USER_ROLE_INVALID);
        }
    }
}