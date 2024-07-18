package com.gymory.domain.user.data;

import com.gymory.domain.user.dto.CustomerDto;
import com.gymory.domain.user.dto.TrainerDto;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@NoArgsConstructor
@DiscriminatorValue("TRAINER")
public class Trainer extends UserEntity {

    // TODO: justify columns
    private String exampleColumns;

    @Builder
    private Trainer(String username, String email, String password, String exampleColumns) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.exampleColumns = exampleColumns;
    }

    public static Trainer create(TrainerDto trainerDto){
        return Trainer.builder()
                .username(trainerDto.getUsername())
                .email(trainerDto.getEmail())
                .password(trainerDto.getPassword())
                .exampleColumns(trainerDto.getExampleColumns())
                .build();
    }
}
