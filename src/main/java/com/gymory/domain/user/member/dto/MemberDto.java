package com.gymory.domain.user.member.dto;

import com.gymory.domain.user.userbase.dto.UserDto;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto extends UserDto {
    private String exampleColumns;
}
