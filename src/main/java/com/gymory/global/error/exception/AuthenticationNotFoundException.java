package com.gymory.global.error.exception;

import com.gymory.global.error.ErrorCode;

public class AuthenticationNotFoundException extends BusinessException {
    public AuthenticationNotFoundException() {
        super(ErrorCode.AUTHENTICATION_NOT_FOUND);
    }
}