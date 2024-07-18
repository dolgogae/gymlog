package com.gymory.domain.user.dto;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GymDto extends UserDto{
    private String exampleColumns;
}
