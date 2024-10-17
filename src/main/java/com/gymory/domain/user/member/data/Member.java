package com.gymory.domain.user.member.data;

import com.gymory.domain.user.userbase.data.UserBase;
import com.gymory.domain.user.member.dto.MemberCreateDto;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@DiscriminatorValue("CUSTOMER")
public class Member extends UserBase {

    // TODO: justify columns
    private String exampleColumns;

    @Builder
    private Member(String username, String email, String password, String exampleColumns) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.exampleColumns = exampleColumns;
    }

    public static Member create(MemberCreateDto memberCreateDto){
        return Member.builder()
                .username(memberCreateDto.getUsername())
                .email(memberCreateDto.getEmail())
                .password(memberCreateDto.getPassword())
                .exampleColumns(memberCreateDto.getExampleColumn())
                .build();
    }
}
