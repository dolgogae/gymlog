package com.gymory.domain.user.gym.data;

import com.gymory.domain.user.gym.dto.GymCreateDto;
import com.gymory.domain.user.userbase.data.UserBase;
import com.gymory.domain.user.gym.dto.GymDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Getter
@Entity
@NoArgsConstructor
@DiscriminatorValue("GYM")
public class Gym extends UserBase {

    // TODO: justify columns
    private String location;
    private String phoneNumber;
    private String etcInfo;    // nearby any stations
    @Embedded
    private UsageInfo usageInfo;


    @Builder
    private Gym(String username, String email, String password, String location,
                String phoneNumber, String etcInfo, UsageInfo usageInfo) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.etcInfo = etcInfo;
        this.usageInfo = usageInfo;
    }

    public static Gym create(GymCreateDto gymDto){
        return Gym.builder()
                .username(gymDto.getUsername())
                .email(gymDto.getEmail())
                .password(gymDto.getPassword())
                .location(gymDto.getLocation())
                .phoneNumber(gymDto.getPhoneNumber())
                .etcInfo(gymDto.getEtcInfo())
                .usageInfo(UsageInfo.create(gymDto.getUsageInfoDto()))
                .build();
    }

    @Embeddable
    @Getter
    @NoArgsConstructor
    public static class UsageInfo{
        private Boolean parking;
        private Boolean wear;
        private Boolean locker;

        @Builder
        public UsageInfo(Boolean parking, Boolean wear, Boolean locker) {
            this.parking = parking;
            this.wear = wear;
            this.locker = locker;
        }

        public static UsageInfo create(GymDto.GymUsageInfoDto usageInfoDto){
            return UsageInfo.builder()
                    .locker(usageInfoDto.getLocker())
                    .parking(usageInfoDto.getParking())
                    .wear(usageInfoDto.getWear())
                    .build();
        }
    }
}
