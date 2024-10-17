package com.gymory.domain.user.member.repository;

import com.gymory.domain.user.member.data.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
