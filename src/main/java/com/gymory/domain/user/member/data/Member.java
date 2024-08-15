package com.gymory.domain.user.member.data;

import com.gymory.domain.user.base.data.UserEntity;
import com.gymory.domain.user.member.dto.CustomerDto;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@DiscriminatorValue("CUSTOMER")
public class Member extends UserEntity {

    // TODO: justify columns
    private String exampleColumns;

    @Builder
    private Member(String username, String email, String password, String exampleColumns) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.exampleColumns = exampleColumns;
    }

    public static Member create(CustomerDto customerDto){
        return Member.builder()
                .username(customerDto.getUsername())
                .email(customerDto.getEmail())
                .password(customerDto.getPassword())
                .exampleColumns(customerDto.getExampleColumns())
                .build();
    }
}
