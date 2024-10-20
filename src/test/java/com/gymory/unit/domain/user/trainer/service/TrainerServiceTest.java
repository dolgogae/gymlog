package com.gymory.unit.domain.user.trainer.service;

import com.gymory.domain.user.member.data.Member;
import com.gymory.domain.user.member.dto.MemberCreateDto;
import com.gymory.domain.user.member.dto.MemberDto;
import com.gymory.domain.user.member.repository.MemberRepository;
import com.gymory.domain.user.member.service.MemberService;
import com.gymory.domain.user.userbase.UserRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class MemberServiceTest {
    ModelMapper modelMapper = new ModelMapper();
    @MockBean
    MemberRepository memberRepository;
    MemberService memberService;

    @BeforeEach
    void init(){
        memberService = new MemberService(memberRepository, modelMapper);
    }

    @Test
    void createMemberTest(){
        // given
        MemberCreateDto memberCreateDto = MemberCreateDto.builder()
                .username("username")
                .email("test@email.com")
                .password("1234")
                .role(UserRole.MEMBER)
                .exampleColumn("exampleColumn")
                .build();
        MemberDto expectedResult = MemberDto.builder()
                .username("username")
                .email("test@email.com")
                .password("1234")
                .role(UserRole.MEMBER)
                .exampleColumn("exampleColumn")
                .build();
        Member member = Member.create(memberCreateDto);
        when(memberRepository.save(any())).thenReturn(member);

        // when
        MemberDto result = memberService.createMember(memberCreateDto);

        // then
        assertThat(result).usingRecursiveComparison().isEqualTo(expectedResult);
    }
}