package com.gymory.domain.user.member.repository;

import com.gymory.domain.user.member.data.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Member, Long> {
}
