package com.gymory.domain.user.customer.dto;

import com.gymory.domain.user.base.dto.UserDto;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto extends UserDto {
    private String exampleColumns;
}
