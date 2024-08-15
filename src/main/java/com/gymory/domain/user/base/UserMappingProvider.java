package com.gymory.domain.user.base;

import com.gymory.domain.user.base.data.UserEntity;
import com.gymory.domain.user.base.dto.UserDto;
import com.gymory.domain.user.base.dto.UserCreateDto;
import com.gymory.domain.user.base.dto.UserResponseDto;
import com.gymory.domain.user.trainer.dto.TrainerCreateDto;
import com.gymory.domain.user.trainer.dto.TrainerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserMappingProvider {

    private final ModelMapper mapper;

    public UserDto requestDtoToDto(UserCreateDto requestDto){
        return mapper.map(requestDto, UserDto.class);
    }
    public UserResponseDto userDtoToResponseDto(UserDto userDto){
        return mapper.map(userDto, UserResponseDto.class);
    }
    public UserDto userEntityToUserDto(UserEntity user){
        return mapper.map(user, UserDto.class);
    }

    public UserResponseDto trainerDtoToResponseDto(TrainerDto trainerDto){
        return mapper.map(trainerDto, UserResponseDto.class);
    }
}
