package com.gymory.domain.user.member.controller;

import com.gymory.domain.user.member.dto.MemberCreateDto;
import com.gymory.domain.user.member.service.MemberService;
import com.gymory.domain.user.userbase.dto.UserCreateDto;
import com.gymory.global.code.result.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

}
