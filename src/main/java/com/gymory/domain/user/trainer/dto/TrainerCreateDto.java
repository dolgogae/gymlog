package com.gymory.domain.user.trainer.dto;

import com.gymory.domain.user.userbase.dto.UserCreateDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "트레이너 생성 DTO")
public class TrainerCreateDto extends UserCreateDto {
    private String shortIntroduction;
    private String longIntroduction;
}
