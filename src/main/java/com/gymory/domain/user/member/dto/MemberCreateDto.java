package com.gymory.domain.user.member.dto;

import com.gymory.domain.user.userbase.dto.UserCreateDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "멤버(고객) 생성 DTO")
public class MemberCreateDto extends UserCreateDto {
    // TODO: need to add member's column
    private String exampleColumn;
}
