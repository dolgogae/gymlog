package com.gymory.domain.user.dto;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TrainerDto extends UserDto{
    private String exampleColumns;
}
