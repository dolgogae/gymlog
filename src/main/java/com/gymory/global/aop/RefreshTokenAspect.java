package com.gymory.global.aop;

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
    private static final ThreadLocal<String> emailThreadLocal = new ThreadLocal<>();


    @Before("@annotation(validateRefreshToken)")
    public void validateToken(JoinPoint joinPoint, ValidateRefreshToken validateRefreshToken) {
        String refreshToken = request.getHeader("Refresh-Token");
        if (refreshToken == null || !validateRefreshToken(refreshToken)) {
            throw new RuntimeException("Invalid or missing refresh token");
        }

        // refreshToken에서 email을 추출하는 로직
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

    // TODO: 구현 필요, refreshToken에서 email 추출
    private String extractEmailFromToken(String refreshToken) {
        // refreshToken에서 email을 추출하는 로직을 구현합니다.
        // 예: JWT에서 클레임으로 email 추출
        return "extracted-email@example.com"; // 실제 구현 필요
    }

    public static String getEmail() {
        return emailThreadLocal.get();
    }

    public static void clearEmail() {
        emailThreadLocal.remove();
    }
}
