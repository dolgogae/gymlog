package com.gymory;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableCaching
@EnableJpaAuditing
@SpringBootApplication//(exclude={SecurityAutoConfiguration.class})
public class GymoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(GymoryApplication.class, args);
    }
}
