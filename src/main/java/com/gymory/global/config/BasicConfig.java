package com.gymory.global.config;

import com.gymory.domain.fee.data.Fee;
import com.gymory.domain.fee.dto.FeeDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;
import static org.modelmapper.config.Configuration.AccessLevel.PROTECTED;

@Configuration
public class BasicConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(PRIVATE)
                .setMethodAccessLevel(PROTECTED);
        modelMapper.addMappings(new PropertyMap<Fee, FeeDto>() {
            @Override
            protected void configure() {
                map(source.getTrainer().getId(), destination.getTrainerId());
            }
        });
        return modelMapper;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
