package com.gymory.domain.user.userbase.service;

import com.gymory.domain.user.gym.dto.GymCreateDto;
import com.gymory.domain.user.gym.dto.GymDto;
import com.gymory.domain.user.gym.service.GymService;
import com.gymory.domain.user.member.dto.MemberCreateDto;
import com.gymory.domain.user.member.dto.MemberDto;
import com.gymory.domain.user.member.service.MemberService;
import com.gymory.domain.user.trainer.dto.TrainerCreateDto;
import com.gymory.domain.user.trainer.dto.TrainerDto;
import com.gymory.domain.user.trainer.service.TrainerService;
import com.gymory.domain.user.userbase.UserRole;
import com.gymory.domain.user.userbase.data.UserBase;
import com.gymory.domain.user.userbase.dto.UserCreateDto;
import com.gymory.domain.user.userbase.dto.UserDto;
import com.gymory.domain.user.userbase.repository.UserJpaRepository;
import com.gymory.global.code.error.ErrorCode;
import com.gymory.global.code.error.exception.BusinessException;
import com.gymory.global.code.result.ResultCode;
import com.gymory.global.code.result.ResultResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final ModelMapper modelMapper;
    private final UserDtoConverter userDtoConverter;

    private final UserJpaRepository userJpaRepository;

    private final TrainerService trainerService;
    private final MemberService memberService;
    private final GymService gymService;

    public UserDto findUserAndUpdateTokens(Long id, String accessToken, String refreshToken) {
        UserBase user = userJpaRepository.findById(id).orElseThrow(() ->
                new BusinessException(ErrorCode.USER_NOT_EXIST));
        user.setTokens(accessToken, refreshToken);

        UserBase savedUser = userJpaRepository.save(user);

        UserDto userDto = modelMapper.map(savedUser, UserDto.class);
        return userDto;
    }

    public ResultResponse registerUser(UserCreateDto userCreateDto) {
        UserRole role = userCreateDto.getRole();
        if (role == null) {
            throw new BusinessException(ErrorCode.USER_ROLE_DOES_NOT_EXISTS);
        }

        switch (role) {
            case TRAINER -> {
                TrainerCreateDto trainerCreateDto = userDtoConverter.toTrainerDto(userCreateDto);
                TrainerDto savedTrainer = trainerService.creatTrainer(trainerCreateDto);
                return ResultResponse.of(ResultCode.REGISTER_SUCCESS, savedTrainer);
            }
            case MEMBER -> {
                MemberCreateDto memberCreateDto = userDtoConverter.toMemberDto(userCreateDto);
                MemberDto savedMember = memberService.createMember(memberCreateDto);
                return ResultResponse.of(ResultCode.REGISTER_SUCCESS, savedMember);
            }
            case GYM -> {
                GymCreateDto gymCreateDto = userDtoConverter.toGymDto(userCreateDto);
                GymDto savedGym = gymService.createGym(gymCreateDto);
                return ResultResponse.of(ResultCode.REGISTER_SUCCESS, savedGym);
            }
            default -> throw new BusinessException(ErrorCode.USER_ROLE_DOES_NOT_EXISTS);
        }
    }
}

