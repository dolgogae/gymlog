package com.gymory.domain.user.userbase.dto;

import com.gymory.domain.user.userbase.UserRole;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    protected Long id;
    protected String username;
    protected String email;
    protected String password;
    protected UserRole role;
}
