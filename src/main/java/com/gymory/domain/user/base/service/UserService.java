package com.gymory.domain.user.base.service;

import com.gymory.domain.user.base.UserMappingProvider;
import com.gymory.domain.user.base.data.UserEntity;
import com.gymory.domain.user.base.dto.UserDto;
import com.gymory.domain.user.base.repository.UserJpaRepository;
import com.gymory.global.code.error.ErrorCode;
import com.gymory.global.code.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserJpaRepository userJpaRepository;
    private final UserMappingProvider userMappingProvider;


//    public UserDto createUser(UserDto userDto) {
//        userDto.setRole(UserRole.ANONYMOUS.name());
//        UserEntity userEntity = UserEntity.create(userDto);
//        UserEntity savedUser = userJpaRepository.save(userEntity);
//
//        UserDto result = userMappingProvider.userEntityToUserDto(savedUser);
//        log.info(result.toString());
//
//        return result;
//    }

    public UserDto findUserAndUpdateTokens(Long id, String accessToken, String refreshToken) {
        UserEntity user = userJpaRepository.findById(id).orElseThrow(() ->
                new BusinessException(ErrorCode.USER_NOT_EXIST));
        user.setTokens(accessToken, refreshToken);

        UserEntity savedUser = userJpaRepository.save(user);

        UserDto userDto = userMappingProvider.userEntityToUserDto(savedUser);

        return userDto;
    }
}
