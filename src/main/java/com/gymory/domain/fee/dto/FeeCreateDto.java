package com.gymory.domain.fee.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FeeCreateDto {
    private Long trainerId;
    private Long price;
    private Integer frequency;
}
