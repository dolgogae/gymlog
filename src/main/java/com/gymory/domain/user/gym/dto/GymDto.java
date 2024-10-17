package com.gymory.domain.user.gym.dto;

import com.gymory.domain.user.userbase.dto.UserDto;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GymDto extends UserDto {

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
