package com.gymory.domain.user.base.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    protected Long id;
    protected String username;
    protected String email;
    protected String password;
    protected String role;
}
