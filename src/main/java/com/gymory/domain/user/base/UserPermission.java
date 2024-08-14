package com.gymory.domain.user.base;

import com.gymory.global.code.error.ErrorCode;
import com.gymory.global.code.error.exception.BusinessException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserPermission {

    ANONYMOUS("ROLE_ANONYMOUS", "미가입 사용자"),
    MEMBER("ROLE_MEMBER", "일반 사용자"),
    TRAINER("ROLE_TRAINER", "트레이너"),
    GYM("ROLE_GYM", "체육관"),
    ADMIN("ROLE_ADMIN", "관리자");

    private final String key;
    private final String title;

    public static UserPermission fromKey(String key) {
        for (UserPermission permission : UserPermission.values()) {
            if (permission.getKey().equalsIgnoreCase(key)) {
                return permission;
            }
        }
        throw new BusinessException("No enum constant with key ", ErrorCode.INVALID_TYPE_VALUE);
    }
}
