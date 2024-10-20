package com.gymory.domain.user.trainer.service;

import com.gymory.domain.user.trainer.data.Trainer;
import com.gymory.domain.user.trainer.dto.TrainerCreateDto;
import com.gymory.domain.user.trainer.dto.TrainerDto;
import com.gymory.domain.user.trainer.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrainerService {
    private final TrainerRepository trainerRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public TrainerDto creatTrainer(TrainerCreateDto trainerCreateDto){
        Trainer trainer = Trainer.create(trainerCreateDto);
        Trainer savedTrainer = trainerRepository.save(trainer);

        TrainerDto result = modelMapper.map(savedTrainer, TrainerDto.class);
        return result;
    }
}
