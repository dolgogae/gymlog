package com.gymory.domain.user.customer.repository;

import com.gymory.domain.user.customer.data.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
