package com.gymory.global.aop;

import com.gymory.domain.user.userbase.UserRole;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateRefreshToken {
    UserRole role() default UserRole.ANONYMOUS;
}
