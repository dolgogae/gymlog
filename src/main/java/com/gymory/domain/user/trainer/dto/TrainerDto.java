package com.gymory.domain.user.trainer.dto;

import com.gymory.domain.user.userbase.dto.UserDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class TrainerDto extends UserDto {

    private String shortIntroduction;
    private String longIntroduction;
}
