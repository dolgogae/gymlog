package com.gymory.global.aop;

import com.gymory.global.code.error.ErrorCode;
import com.gymory.global.code.error.exception.BusinessException;
import com.gymory.global.config.AES128Config;
import com.gymory.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@RequiredArgsConstructor
public class RefreshTokenAspect {

    private final HttpServletRequest request;
    private final JwtTokenProvider jwtTokenProvider;
    private final AES128Config aes128Config;
    private static final ThreadLocal<String> emailThreadLocal = new ThreadLocal<>();


    @Before("@annotation(validateRefreshToken)")
    public void validateToken(JoinPoint joinPoint, ValidateRefreshToken validateRefreshToken) {
        String refreshToken = aes128Config.decryptAes(request.getHeader("Refresh-Token"));
        if (refreshToken == null || !validateRefreshToken(refreshToken)) {
            throw new BusinessException("Invalid or missing refresh token", ErrorCode.TOKEN_UNSUPPORTED);
        }

        if(validateRefreshToken.role() != jwtTokenProvider.getUserPermission(refreshToken)){
            throw new BusinessException("This role have no permission this API", ErrorCode.METHOD_NOT_ALLOWED);
        }

        String email = extractEmailFromToken(refreshToken);
        emailThreadLocal.set(email);
    }

    @After("@annotation(com.gymory.global.aop.ValidateRefreshToken)")
    public void clearThreadLocal() {
        emailThreadLocal.remove();
    }

    private boolean validateRefreshToken(String refreshToken) {
        return jwtTokenProvider.validateToken(refreshToken);
    }

    private String extractEmailFromToken(String refreshToken) {
        return jwtTokenProvider.getUserEmail(refreshToken);
    }

    public static String getEmail() {
        return emailThreadLocal.get();
    }

    public static void clearEmail() {
        emailThreadLocal.remove();
    }
}

