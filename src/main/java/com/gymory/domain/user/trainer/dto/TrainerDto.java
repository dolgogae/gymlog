package com.gymory.domain.user.trainer.dto;

import com.gymory.domain.user.base.dto.UserDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
public class TrainerDto extends UserDto {

    private String shortIntroduction;
    private String longIntroduction;
}
