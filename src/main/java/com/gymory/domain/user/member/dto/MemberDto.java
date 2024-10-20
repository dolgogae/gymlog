package com.gymory.domain.user.member.dto;

import com.gymory.domain.user.userbase.dto.UserDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto extends UserDto {
    private String exampleColumn;
}
