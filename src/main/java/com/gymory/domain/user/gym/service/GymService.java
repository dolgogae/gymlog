package com.gymory.domain.user.gym.service;

import com.gymory.domain.user.gym.data.Gym;
import com.gymory.domain.user.gym.dto.GymCreateDto;
import com.gymory.domain.user.gym.dto.GymDto;
import com.gymory.domain.user.gym.repository.GymRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GymService {
    private final ModelMapper modelMapper;
    private final GymRepository gymRepository;

    public GymDto createGym(GymCreateDto gymCreateDto){
        Gym gym = Gym.create(gymCreateDto);
        Gym savedGym = gymRepository.save(gym);

        GymDto result = modelMapper.map(savedGym, GymDto.class);
        return result;
    }
}
