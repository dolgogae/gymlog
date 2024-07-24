package com.gymory.domain.user.trainer.repository;

import com.gymory.domain.user.trainer.data.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
