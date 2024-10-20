package com.gymory.domain.fee.repository;

import com.gymory.domain.fee.data.Fee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeeRepository extends JpaRepository<Fee, Long> {
}
