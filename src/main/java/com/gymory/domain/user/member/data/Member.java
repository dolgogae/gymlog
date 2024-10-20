package com.gymory.domain.user.member.data;

import com.gymory.domain.user.userbase.UserRole;
import com.gymory.domain.user.userbase.data.UserBase;
import com.gymory.domain.user.member.dto.MemberCreateDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Entity
@NoArgsConstructor
@DiscriminatorValue("MEMBER")
public class Member extends UserBase {

    // TODO: justify columns
    private String exampleColumn;

    @Builder
    private Member(String username, String email, String password, UserRole role, String exampleColumn) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.exampleColumn = exampleColumn;
    }

    public static Member create(MemberCreateDto memberCreateDto){
        return Member.builder()
                .username(memberCreateDto.getUsername())
                .email(memberCreateDto.getEmail())
                .password(memberCreateDto.getPassword())
                .role(memberCreateDto.getRole())
                .exampleColumn(memberCreateDto.getExampleColumn())
                .build();
    }
}
