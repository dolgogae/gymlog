package com.gymory.domain.user.member.service;

import com.gymory.domain.user.member.data.Member;
import com.gymory.domain.user.member.dto.MemberCreateDto;
import com.gymory.domain.user.member.dto.MemberDto;
import com.gymory.domain.user.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    public MemberDto createMember(MemberCreateDto memberCreateDto){
        Member member = Member.create(memberCreateDto);
        Member savedMember = memberRepository.save(member);

        MemberDto result = modelMapper.map(savedMember, MemberDto.class);
        return result;
    }
}
