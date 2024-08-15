package com.gymory.domain.user.trainer.data;

import com.gymory.domain.certification.data.Certificate;
import com.gymory.domain.fee.data.Fee;
import com.gymory.domain.user.base.data.UserEntity;
import com.gymory.domain.user.trainer.dto.TrainerCreateDto;
import com.gymory.domain.user.trainer.dto.TrainerDto;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@DiscriminatorValue("TRAINER")
public class Trainer extends UserEntity {

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Certificate> certificates = new ArrayList<>();

    private String shortIntroduction;
    private String longIntroduction;

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Fee> fees = new ArrayList<>();


    @Builder
    private Trainer(String username, String email, String password, String shortIntroduction, String longIntroduction) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.shortIntroduction = shortIntroduction;
        this.longIntroduction = longIntroduction;
    }

    public static Trainer create(TrainerCreateDto trainerDto){
        return Trainer.builder()
                .username(trainerDto.getUsername())
                .email(trainerDto.getEmail())
                .password(trainerDto.getPassword())
                .shortIntroduction(trainerDto.getShortIntroduction())
                .longIntroduction(trainerDto.getLongIntroduction())
                .build();
    }
}
