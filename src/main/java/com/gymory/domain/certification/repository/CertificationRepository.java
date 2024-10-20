package com.gymory.domain.certification.repository;

import com.gymory.domain.certification.data.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificationRepository extends JpaRepository<Certification, Long> {
}
