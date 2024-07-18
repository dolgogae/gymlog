package com.gymory.domain.user.dto;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto extends UserDto{
    private String exampleColumns;
}
