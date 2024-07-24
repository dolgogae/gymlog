package com.gymory.domain.user.gym.repository;

import com.gymory.domain.user.gym.data.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymRepository extends JpaRepository<Gym, Long> {
}
