package com.gymory.domain.user.dto;

import lombok.*;
@Data
@Builder @ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    protected Long id;
    protected String username;
    protected String email;
    protected String password;
    protected String role;
}
