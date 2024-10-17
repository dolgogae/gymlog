package com.gymory.domain.user.userbase.controller;

import com.gymory.domain.user.gym.dto.GymCreateDto;
import com.gymory.domain.user.gym.dto.GymDto;
import com.gymory.domain.user.gym.service.GymService;
import com.gymory.domain.user.member.dto.MemberCreateDto;
import com.gymory.domain.user.member.dto.MemberDto;
import com.gymory.domain.user.trainer.dto.TrainerCreateDto;
import com.gymory.domain.user.trainer.dto.TrainerDto;
import com.gymory.domain.user.userbase.UserRole;
import com.gymory.domain.user.userbase.dto.TokenDto;
import com.gymory.domain.user.userbase.dto.UserCreateDto;
import com.gymory.domain.user.userbase.dto.UserDto;
import com.gymory.domain.user.userbase.service.UserDtoConverter;
import com.gymory.domain.user.userbase.service.UserService;
import com.gymory.domain.user.member.service.MemberService;
import com.gymory.domain.user.trainer.service.TrainerService;
import com.gymory.global.code.error.ErrorCode;
import com.gymory.global.code.error.exception.BusinessException;
import com.gymory.global.code.result.ResultCode;
import io.swagger.v3.oas.annotations.Operation;
import com.gymory.global.code.result.ResultResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final TrainerService trainerService;
    private final MemberService memberService;
    private final GymService gymService;

    private final PasswordEncoder passwordEncoder;
    private final UserDtoConverter userDtoConverter;

    @PostMapping("/sign-up")
    public ResponseEntity<ResultResponse> signIn(
            @RequestBody @Valid UserCreateDto userCreateDto
    ){
        userCreateDto.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));

        ResultResponse result = userService.registerUser(userCreateDto);
        return new ResponseEntity<>(result, HttpStatus.valueOf(result.getStatus()));
    }

    @Operation(summary = "JWT 로그인 성공 콜백 함수", description = "JWT 로그인 이후 성공 콜백 함수")
    @GetMapping("/login/callback")
    public ResponseEntity<ResultResponse> loginCallback(
            @RequestParam @NotBlank String accessToken, @RequestParam @NotBlank String refreshToken
    ){
        log.info("accessToken = {} refreshToken={}", accessToken, refreshToken);

        TokenDto tokenDto = TokenDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();

        ResultResponse result = ResultResponse.of(ResultCode.LOGIN_SUCCESS, tokenDto);
        return new ResponseEntity<>(result, HttpStatus.valueOf(result.getStatus()));
    }
}
