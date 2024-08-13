package com.gymory.domain.user.gym.service;

import com.gymory.domain.user.gym.dto.GymCreateDto;
import com.gymory.domain.user.gym.dto.GymDto;
import com.gymory.domain.user.gym.repository.GymRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GymService {

    private final GymRepository gymRepository;

    public GymDto createGym(GymCreateDto gymCreateDto){
        return null;
    }
}
