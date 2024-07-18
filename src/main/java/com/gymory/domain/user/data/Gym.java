package com.gymory.domain.user.data;

import com.gymory.domain.user.dto.CustomerDto;
import com.gymory.domain.user.dto.GymDto;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@DiscriminatorValue("GYM")
public class Gym extends UserEntity {

    // TODO: justify columns
    private String exampleColumns;

    @Builder
    private Gym(String username, String email, String password, String exampleColumns) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.exampleColumns = exampleColumns;
    }

    public static Gym create(GymDto gymDto){
        return Gym.builder()
                .username(gymDto.getUsername())
                .email(gymDto.getEmail())
                .password(gymDto.getPassword())
                .exampleColumns(gymDto.getExampleColumns())
                .build();
    }
}
