package com.gymory.domain.user.dto;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GymDto extends UserDto{

    private String location;
    private String phoneNumber;
    private String etcInfo;    // nearby any stations
    private GymUsageInfoDto usageInfoDto;


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GymUsageInfoDto{
        private Boolean parking;
        private Boolean wear;
        private Boolean locker;
    }
}
