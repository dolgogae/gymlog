package com.gymory.domain.auth;

import com.gymory.domain.user.base.UserMappingProvider;
import com.gymory.domain.user.base.dto.UserDto;
import com.gymory.domain.user.base.dto.UserCreateDto;
import com.gymory.domain.user.base.dto.UserResponseDto;
import com.gymory.domain.user.base.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import com.gymory.global.code.result.ResultCode;
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
    private final UserMappingProvider userMappingProvider;
    private final PasswordEncoder passwordEncoder;

    @Operation(summary = "회원가입(sign-in)", description = "회원가입을 위한 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "회원가입 성공",
                    content = @Content(schema = @Schema(implementation = UserCreateDto.class)))
    })
    @PostMapping("/sign-in")
    public ResponseEntity<ResultResponse> signIn(
            @RequestBody @Valid UserCreateDto request
    ){
        log.info(request.toString());

        request.setPassword(passwordEncoder.encode(request.getPassword()));
        UserDto userDto = userMappingProvider.requestDtoToDto(request);
        // TODO: divide by role
        UserDto user = new UserDto(); //userService.createUser(userDto);

        log.info("create user = {}", user.toString());

        UserResponseDto userResponseDto = userMappingProvider.userDtoToResponseDto(user);

        ResultResponse result = ResultResponse.of(ResultCode.REGISTER_SUCCESS, userResponseDto);
        return new ResponseEntity<>(result, HttpStatus.valueOf(result.getStatus()));
    }

    @Operation(summary = "JWT 로그인 성공 콜백 함수", description = "JWT 로그인 이후 성공 콜백 함수")
    @GetMapping("/login/callback")
    public String loginCallback(
            @RequestParam @NotBlank String accessToken, @RequestParam @NotBlank String refreshToken
    ){
        log.info("accessToken = {} refreshToken={}", accessToken, refreshToken);
        return refreshToken;
    }
}
