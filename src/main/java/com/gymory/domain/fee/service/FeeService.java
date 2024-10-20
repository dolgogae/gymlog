package com.gymory.domain.fee.service;

import com.gymory.domain.fee.data.Fee;
import com.gymory.domain.fee.dto.FeeCreateDto;
import com.gymory.domain.fee.dto.FeeDto;
import com.gymory.domain.fee.dto.FeeUpdateDto;
import com.gymory.domain.fee.repository.FeeRepository;
import com.gymory.domain.user.trainer.data.Trainer;
import com.gymory.domain.user.trainer.repository.TrainerRepository;
import com.gymory.global.code.error.ErrorCode;
import com.gymory.global.code.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeeService {
    private ModelMapper modelMapper;

    private final FeeRepository feeRepository;
    private final TrainerRepository trainerRepository;

    public FeeDto createFee(FeeCreateDto feeCreateDto){
        Trainer trainer = trainerRepository.findById(feeCreateDto.getTrainerId()).orElseThrow(() ->
                new BusinessException(ErrorCode.USER_NOT_EXIST));

        Fee fee = Fee.create(feeCreateDto, trainer);
        Fee savedFee = feeRepository.save(fee);

        FeeDto result = modelMapper.map(savedFee, FeeDto.class);
        return result;
    }

    public FeeDto updateFee(FeeUpdateDto feeUpdateDto){
        Fee fee = feeRepository.findById(feeUpdateDto.getFeeId()).orElseThrow(() ->
                new BusinessException(ErrorCode.USER_NOT_EXIST));
        fee.updateFee(feeUpdateDto);
        Fee savedFee = feeRepository.save(fee);

        FeeDto result = modelMapper.map(savedFee, FeeDto.class);
        return result;
    }

    public void deleteFee(Long feeId){
        feeRepository.deleteById(feeId);
    }
}
